//业务js
function popWin(id){
	$("#"+id).css("display","block");
}
$("#close").click(function(){
	$(this).parent().css("display","none");
});
//顶部菜单单击事件
function topmenu_item_baseurl_click(f,id)
{
	if(id==undefined){
		cpcMain.loadMenuLeft("/main/menu/left?f=left&id=1","leftmenu_item_router");
	}else{
		cpcMain.loadMenuLeft("/main/menu/left?f=left&id="+id,"leftmenu_item_router");
	}
    
}
function topmenu_item_empurl_click(f,id)
{
    cpcMain.loadMenuLeft("/main/menu/left?f=left&id="+id,"leftmenu_item_router");
}
function topmenu_item_stuurl_click(f,id)
{
    cpcMain.loadMenuLeft("/main/menu/left?f=left&id="+id,"leftmenu_item_router");
}
function topmenu_item_sysurl_click(f,id)
{
    cpcMain.loadMenuLeft("/main/menu/left?f=left&id="+id,"leftmenu_item_router");
}
//入职管理
function leftmenu_item_inurl_click(){
	cpcMain.loadSearchResultGrid("/inurl/getData",null,function(){
		$(".opt a").on("click",function(){
			var id = $(this).attr("id");
//			alert(id);
			console.info(id);
			var ids=id.split("_");
			if(ids[0]=="view"){
				cpcMain.loadPopWinMagWindow("/inurl/view");
			}else if(ids[0]=="update"){
				cpcMain.loadPopWinMagWindow("/inurl/view");
			}else if(ids[0]=="del"){
//				$.ajax({
//					url:"",
//					type:"post",
//					data:"",
//					dataType:"json",
//					success:function(data){
//						
//					}
//				});
			}
		})
	});
}