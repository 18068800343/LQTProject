(function(window){
	$.ajax({
		type:"post",
		url:"/login/getUser",//用户权限数组
		data:{
		},
		success:function(json){
			if(json!=null &&json!=""){
			var arr = json.uPermissions.split(',');
				$.ajax({
					type:"post",
					url:"/UPermissionsRole/getAllUPermissionsRole",
					data:{
					},
				success:function(json2){
					var arr2 =[];
					for(var a=0;a<json2.length;a++){
						arr2.push(json2[a].coding)
					}
					for(var i=0;i<arr.length;i++){
						userbm=arr[i];
							for(var j=0;j<arr2.length;j++){
								var qbbm=arr2[j]
								if(qbbm.indexOf(userbm)>=0){
									var c=$.inArray(userbm,arr2);
									arr2.splice($.inArray(userbm,arr2),1);
								}
                            
						}
					}
						//要删除的集合
						//console.log(arr2)
						for(var j=0;j<arr2.length;j++){
								var arr4 = arr2[j].replace("+","");
								if(arr4=="Pab"){
									console.log(arr4)
								}
								$("."+arr4+"").hide();
								$("."+arr4+"").closest("li").remove();//通过编码 点 remove
									
						}
					}
			    });
			/*	for(var i=0;i<arr.length;i++){
					var arr2 = arr[i].replace("+","");
					$("."+arr2+"").show();
				}*/
			}else{
				
			}
		}
	});

	

	
	
})(window);


