/**
 * Created by Administrator on 2016/5/19.
 */
function page_item_router(callback,pageid)
{
	var ulTag = "";
	var jumpTag = "";
	var activate = "";
	var totalPage = "";
	if(pageid!=undefined){
		ulTag = "#"+pageid + " ul.pagination > li > a";
		jumpTag= "#"+pageid + " input[id='jump']";
		activate = "#"+pageid+" li.active > a";
		totalPage = "#"+pageid+" span.totalPage";
	}else{
		ulTag="ul.pagination > li > a";
		jumpTag="#jump";
		activate = "li.active > a";
		totalPage = "span.totalPage";
	}
	
    var ul = $(ulTag);
   
    $(jumpTag).unbind("keypress").bind("keypress",totalPage,function(event){
    	var totalPage = event.data;
    	if(event.keyCode == 13){
    		var p = parseInt($(jumpTag).val())-1;
    		
    		var totalPage = parseInt($($(totalPage)[0]).text());
    	
    		if(p < 0){
    			p = 0;
    		}else if(p >= totalPage){
    			p = totalPage-1;
    		}
    		callback(p);
    		return false;
    	}
    });
    

    
    ul.each(function(i,item){
       
    	
        switch($(this).text()){
        
            case "\<\<":
                $(this).unbind("click").bind("click",function(){
                
                    callback(parseInt($(activate).text())-2);
                    return false;
                })
                break;
            case "\>\>":
                $(this).unbind("click").bind("click",function(){
                	
                    callback(parseInt($(activate).text()));
                    return false;
                })
                break;
            case "上页":
            	 $(this).unbind("click").bind("click",function(){

            		 personFindSubmit($(activate).text()-2);
                     return false;
                 })
            	break;
            case "下页":
            	 $(this).unbind("click").bind("click",function(){

            		 personFindSubmit($(activate).text());
                     return false;
                 })
            	break;
            default :
                $(this).unbind("click").bind("click",function(){
                	
                	if(typeof callback == "function"){
                		
                		callback(parseInt($(this).text())-1);
                	}else{
                		personFindSubmit(parseInt($(this).text())-1);
                	}
                	
                    return false;
                });
            

        };
    });
    
    $(activate).unbind();

}

function personFindSubmit(page){
	document.personFind.number.value = page;
	document.personFind.submit();
}