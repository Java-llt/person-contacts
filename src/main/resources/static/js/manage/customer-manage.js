

layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#customer-manage'
    ,url:'/homepageController/listCompany'
    ,page: true
    ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
    ,limit: 10
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[{type: 'checkbox', fixed: 'left'}
      ,{field:'companyName', width:200, title: '客户', sort: true}
      ,{field:'companyAddress', width:200, title: '客户地址'}
      ,{field:'primaryBusiness', width:200, title: '主营业务'} //, width: '30%', minWidth: 100  minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
      //,{field:'sidelineBusiness', width:200, title: '兼营业务'}
      ,{field:'companyDetail', width:200, title: '客户详情'}
      ,{field:'companyTel', width:200, title: '客户电话'}
      ,{field:'telCallNum', width:150, title: '电话拨打次数'}
      ,{field:'starLevel', width:100, title: '公司星级'}
//      ,{field:'homepageSlideshow', width:200, title: '首页轮播图'}
//      ,{field:'listMiniPic', width:200, title: '列表小图'}
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
	  var modal = $('#mylaModal');
	  debugger;
	  switch(obj.event){
	    case 'add':
	    	openModal();
	    break;
	    case 'update':
	      if(data.length === 0){
	        layer.msg('请选择一行');
	      } else if(data.length > 1){
	        layer.msg('只能同时编辑一个');
	      } else {
	    	  openModal(data);
	      }
	    break;
	    case 'delete':
	      if(data.length === 0){
	        layer.msg('请选择数据');
	        break;
	      }
	      var companyIds='';
	  	  $(data).each(function(index) {
	  		companyIds += "'"+data[index].companyId+"',";
	  	  });
		  	companyIds = companyIds.substr(0, companyIds.length-1);
		  	$.ajax({
				url : '/homepageController/delCompanyByIds',
				type : "POST",
				traditional: true,//这里设置为true
				data : {
					companyIds :companyIds,
				},
				success : function(res) {
					if(res.status == 200){
						//刷新table
					}
					layer.msg(res.msg);
				}
			});
	    break;
	    case 'import':
			modal.modal('show');
	    	break;
	  };
	});

});


function saveImport() {
	debugger;
	//限制文件为excel文件
	var file = $("#file").val();
	var index = file.lastIndexOf(".");
	if (index <= 0 || file.substr(index+1) != "xls") {
		layerMsg("'提示', '仅支持xls格式，请重新选择！'");
		return;
	}else{
		layer.confirm('确认导入？', {
			btn : [ '是', '否' ]
			// 按钮
			}, function(index) {
				 var formData = new FormData();
				formData.append("file", document.getElementById("file").files[0]);
				$.ajax({
					url : '/homepageController/importCompanyDatas',
					type : "POST",
					data : formData,
					contentType : false,
					processData : false,
					async : false,
					success : function(data) {
						layerMsg(data);
						var modal = $('#mylaModal');
						modal.modal('hide');
					}
				}); 
			},function(){
				return;
			});
	}
}

/**
 * 打开模态框
 */
function openModal(obj) {
	if(obj) {
//		obj[0].homepageSlideshow = "";
//		obj[0].listMiniPic = "";
		var url = "/homepageController/toCompanyAddPage?companyData="+encodeURI(JSON.stringify(obj[0]));
	}else {
		var url = "/homepageController/toCompanyAddPage";
    }
    layui.use(['layer'],function () {
        var layer = layui.layer,$=layui.$;
        layer.open({
            type:2,//打开一个iframe
            title:'增加',
            content: url,
            area:['800px','600px'],//定义宽和高
            maxmin: true,//最大最小化，默认false
            btn: ['保存', '取消'],
            yes: function(index, layero){
            	debugger;
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
