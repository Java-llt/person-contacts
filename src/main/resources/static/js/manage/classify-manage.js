layui.use('table', function(){
	var type = $("#type").val();
	var table = layui.table;
  table.render({
    elem: '#customer-manage'
    ,url:'/homepageController/listClassify'
    ,page: true
    ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
    ,limit: 10
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,where: {type: type}
    ,cols: [[{type: 'checkbox', fixed: 'left'}
      ,{field:'icon', width:200, title: '图标'}
      ,{field:'name', width:200, title: '名称'}
    ]]
  /*,response: {
    statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
  }*/
  ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
      return {
        "code": res.code, //解析接口状态
        "msg": res.msg, //解析提示文本
        "count": res.count, //解析数据长度
        "data": res.data //解析数据列表
      };
    }
  });
  
	//监听头工具栏事件
	table.on('toolbar(customer-manage)', function(obj){
	  var checkStatus = table.checkStatus(obj.config.id)
	  ,data = checkStatus.data; //获取选中的数据
	  switch(obj.event){
	    case 'add':
	    	openModal();
	    break;
	    case 'update':
	      if(data.length === 0){
	        layer.msg('请选择一行');
	      } else if(data.length > 1){
	        layer.msg('请选择一条数据');
	      } else {
	    	  openModal(data);
	      }
	    break;
	    case 'delete':
	      if(data.length > 1){
	        layer.msg('请选择一条数据');
	        break;
	      }
		  	$.ajax({
				url : '/homepageController/delClassifyById',
				type : "POST",
				traditional: true,//这里设置为true
				data : {
					id :data[0].id,
				},
				success : function(res) {
					if(res.status == 200){
						//刷新table
					}
					layer.msg(res.msg);
				}
			});
	    break;
	  };
	});

});


/**
 * 打开模态框
 */
function openModal(obj) {
	var type = $("#type").val();
	if(obj) {
		var url = "/homepageController/toClassifyEditPage?type="+type+"&data="+encodeURI(JSON.stringify(obj[0]));
	}else {
		var url = "/homepageController/toClassifyEditPage?type="+type;
    }
    layui.use(['layer'],function () {
        var layer = layui.layer,$=layui.$;
        layer.open({
            type:2,//打开一个iframe
            title:'增加',
            content: url,
            area:['580px','380px'],//定义宽和高
            maxmin: true,//最大最小化，默认false
            btn: ['保存', '取消'],
            yes: function(index, layero){
                //点击确认触发 iframe 内容中的按钮提交
                var frm = layero.find('iframe').contents().find("#company_save");
                layer.close(index);
                frm.click();
            }
        });
    })
}


$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
