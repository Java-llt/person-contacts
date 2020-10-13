layui.use('upload', function(){
  var upload = layui.upload;
  //执行实例
  var uploadHomepageSlideshow = upload.render({
    elem: '#homepageBtn' //绑定元素
    ,url: '/homepageController/uploadHomepageSlideshow' //上传接口
    ,before: function(obj){
        //预读本地文件示例，不支持ie8
        obj.preview(function(index, file, result){
          $('#homepageImg').attr('src', result); //图片链接（base64）
        });
      }
	,response: {
	    statusCode: 200 //重新规定成功的状态码为 200， 组件默认为 0
	  }
    ,done: function(res){
      //上传完毕回调
    	if(res.status == 200){
    		$('#homepageSlideshow').val(res.data);
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
  
  //执行实例
  var uploadListMiniPic = upload.render({
	  elem: '#listMiniBtn' //绑定元素
	  ,url: '/homepageController/uploadListMiniPic' //上传接口
	  ,before: function(obj){
        //预读本地文件示例，不支持ie8
        obj.preview(function(index, file, result){
          $('#listMiniImg').attr('src', result); //图片链接（base64）
        });
      }
  	  ,response: {
	    statusCode: 200 //重新规定成功的状态码为 200， 组件默认为 0
	  }
	  ,done: function(res){
		  //上传完毕回调
		  if(res.status == 200){
	    		$('#listMiniPic').val(res.data);
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
	$("#company_save").click(function(){
		debugger;
		$.ajax({
			url:'/homepageController/companySave',
			type:'POST',
			data:{
				companyData : JSON.stringify($("#company_form").serializeObject())
			},
			success: function (data) {
				debugger;
				window.parent.layer.msg(data.msg);
			}
		});
	});
});


function openClassify(){
	layui.use(['layer'],function () {
        var layer = layui.layer,$=layui.$;
        layer.open({
            type:2,//打开一个iframe
            title:'增加',
            content: "/homepageController/toClassifySelectPage",
            area:['480px','480px'],//定义宽和高
            maxmin: true,//最大最小化，默认false
//            btn: ['保存', '取消'],
//            yes: function(index, layero){
//            	debugger;
//                //点击确认触发 iframe 内容中的按钮提交
////                var frm = layero.find('iframe').contents().find("#company_save");
//                layer.close(index);
////                frm.click();
//            }
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
