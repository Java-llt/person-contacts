layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#customer-manage'
    ,url:'/homepageController/selectClassify'
//    ,page: true
    ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
//    ,limit: 10
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[{type: 'checkbox', fixed: 'left'}
      ,{field:'name', width:300, title: '车型'}
    ]]
  	,id: 'classifySelect'
	,height: 378
  /*,response: {
    statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
  }*/
  ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
      return {
        "code": res.status, //解析接口状态
        "msg": res.msg, //解析提示文本
        "count": res.count, //解析数据长度
        "data": res.data //解析数据列表
      };
    }
  });
  
	var $ = layui.$, active = {
	    reload: function(){
	      var title = $('#title');
	      
	      //执行重载
	      table.reload('classifySelect', {
	        where: {
	        	 title: title.val()
	        }
	      }, 'data');
	    }
	  };
	  
	  $('#search-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
  
	//监听头工具栏事件
	table.on('toolbar(customer-manage)', function(obj){
	  var checkStatus = table.checkStatus(obj.config.id)
	  ,$ = layui.$
	  ,data = checkStatus.data; //获取选中的数据
	  var index = parent.layer.getFrameIndex(window.name);
	  debugger;
	  switch(obj.event){
	    case 'save':
	    	var codeStr = '';
	    	var nameStr = '';
	    	for(var i in data){
	    		codeStr += data[i].code + ',';
	    		nameStr += data[i].name + ',';
	    	}
	    	$(window.parent.document).find("#primaryBusinessCode").val(codeStr);
	    	$(window.parent.document).find("#primaryBusinessName").val(nameStr);
	    	parent.layer.close(index);
	    break;
	    case 'concel':
	    	parent.layer.close(index);
	    break;
	  };
	});

});
