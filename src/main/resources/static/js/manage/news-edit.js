layui.use('upload', function(){
  var upload = layui.upload;
  //执行实例
  var uploadNewsPic = upload.render({
    elem: '#homepageBtn' //绑定元素
    ,url: '/homepageController/uploadNewsPic' //上传接口
    ,before: function(obj){
        //预读本地文件示例，不支持ie8
        obj.preview(function(index, file, result){
          $('#newsPic').attr('src', result); //图片链接（base64）
        });
      }
	,response: {
	    statusCode: 200 //重新规定成功的状态码为 200， 组件默认为 0
	  }
    ,done: function(res){
      //上传完毕回调
    	if(res.status == 200){
    		$('#picUrl').val(res.data);
    		layer.msg('上传成功');
    	}else{
    		layer.alert('上传失败,请重新上传或联系管理员...');
    	}
    }
    ,error: function(){
      //请求异常回调
    	layer.alert('上传失败,请重新上传或联系管理员...');
    }
  });
  
});

$(function(){
	debugger;
	//文本域赋值
	$("#news-content").val($("#old-content-val").val());
	
	$("#company_save").click(function(){
		$.ajax({
			url:'/homepageController/newsSave',
			type:'POST',
			data:{
				newsData : JSON.stringify($("#news_form").serializeObject())
			},
			success: function (data) {
				window.parent.layer.msg(data.msg);
			}
		});
	});
});


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
