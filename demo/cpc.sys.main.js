/**
 * Created by guochunhui on 2016/5/14.
 */
/**
 *
 * @param objId required
 * @param url required
 * @param data optional
 * @param callback optional
 */
function loadPostDataById(objId,url,data,callback) {
    if(arguments.length==2) {
        data = null;
        callback = null;
    }
    else
    {
        if(arguments.length==3)
            callback = null;
    }
    if($("#" + objId).length==0){
        $("#iframe").contents().find("#" + objId).hide();
    }else{
        $("#" + objId).hide();
    }
    $.post(url, data,function(reponse) {
    	if($("#" + objId).length==0){
    		$("#iframe").contents().find("#" + objId).html(reponse);
            $("#iframe").contents().find("#" + objId).show();
    	}else{
    		 $("#" + objId).html(reponse);
             $("#" + objId).show();
    	}
        if(callback!=null)
        {
            if(typeof callback === "function")
                callback();
            else if(isExitsFunction(callback))
                eval(callback + "();")
            else
                alert("回调函数无法执行:" + callback + ".");
        }

        //$("#loading").hide();
    });
}
function loadMainMenuLeft(url,callback) {
    if(arguments.length==0) {
        url="/main/menu/left";
        callback=null;
    }else if(arguments.length==1)
    {
        callback=url;
        url="/main/menu/left";
    }
    loadPostDataById("sideBar",url,null,callback);
    empFlag = false;// 特殊处理员工管理
}
function loadMainMenuTop(url,callback) {
    if(arguments.length==0) {
        url="/main/menu/top";
        callback=null;
    }else if(arguments.length==1)
    {
        callback=url;
        url="/main/menu/top";
    }
    loadPostDataById("topBar",url,null,callback);
    
}
function loadSearchForm(url,data,callback) {
    loadPostDataById("searchForm",url,data,callback);
}
function loadSearchResultGrid(url,data,callback) {
	var qid = $("#sideBar .side_nav li[class='on']").attr("qid");
	if(typeof qid != "undefined"){
		if(url.indexOf("?")!=-1){
			url = url + "&qid=" + qid;
		}else{
			url = url + "?qid=" + qid; 
		}
	}
	
    loadPostDataById("searchResultGrid",url,data,function () {
    	$("#searchTermResultGrid").html("");
    	$("#searchScoreltGrid").html("");
    	$("#showresumeotherbtn").hide();
		$("#showresumeCRPbtn").hide();
		$("#showresumePSKbtn").hide();
		$("#showAwardsbtn").hide();
		$("#showscholarshipbtn").hide();
		$("#showWorkExperience").hide();
		$("#showEducationExperience").hide();
		$("#showTraining").hide();
		$("#showCertificate").hide();
		$("#showLanguage").hide();
		$("#showsPracticebtn").hide();
		$("#searchWorkExperienceGrid").html("");
		$("#searchEducationExperienceGrid").html("");
		$("#searchTrainingGrid").html("");
		$("#searchCertificateGrid").html("");
		$("#searchLanguageGrid").html("");
		$("#searchCRPltGrid").html("");
		$("#searchProSkillltGrid").html("");
		$("#searchAWARDSltGrid").html("");
		$("#searchscholarshipltGrid").html("");
		$("#searchPracticeltGrid").html("");
		$("#searchResumeOtherGrid").html("");
		$("div").removeClass("xgjl_2");
		$("div").removeClass("xgjl_3");
        if(callback!=null)
        {
            if(typeof callback === "function")
                page_item_router(callback);
            else if(isExitsFunction(callback))
                eval("page_item_router("+callback+");")
            else
                alert("回调函数无法执行:" + callback + ".");
        }
    });    
}

// 假删除，更新统一用此公共方法
function update(url,datas,callback){
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		data:datas,
		success:function(data){
			var jsonData = eval(data);
			
			if(callback!=null)
	        {
	            if(typeof callback === "function")
	            	callback(jsonData);
	            else if(isExitsFunction(callback))
	                eval(""+callback+"("+jsonData+");")
	            else
	                alert("回调函数无法执行:" + callback + ".");
	        }
		}
	});
}

//删除功能调用此函数
function deleteById(url,datas,callback){
	update(url,datas,callback);
	
}

// 确认函数
function confirmById(url ,datas, callback){
	update(url,datas,callback);
}

function loadSearchResultGridCustom(gridid,pageid,url,data,callback) {
		var qid = $("#sideBar .side_nav li[class='on']").attr("qid");
		if(typeof qid != "undefined"){
			if(url.indexOf("?")!=-1){
				url = url + "&qid=" + qid;
			}else{
				url = url + "?qid=" + qid; 
			}
		}
	    loadPostDataById(gridid,url,data,function () {
	        if(callback!=null)
	        {
	            if(typeof callback === "function")
	                page_item_router(callback,pageid);
	            else if(isExitsFunction(callback))
	                eval("page_item_router("+callback+",'" + pageid +"');")
	            else
	                alert("回调函数无法执行:" + callback + ".");
	        }
	    });    
	}

function loadTabLevelOne(url,data,callback) {
    $("#tabLevelOne").show();
    loadPostDataById("tabLevelOne",url,data,callback);
}
function loadTabLevelTwo(url,data,callback) {
    $("#tabLevelTwo").show();
    loadPostDataById("tabLevelTwo",url,data,callback);
}
function loadMagWindow(url,data,callback) {
    loadPostDataById("detail",url,data,callback);
}
function popWinMagWindow () {
    popWin("detail");
}
function loadPopWinMagWindow(url,data,callback)
{
    loadMagWindow(url,data,function () {
//        popWinMagWindow ();
    	windowToggleOpen();
        if(callback!=null)
        {
            if(typeof callback === "function")
                callback();
            else if(isExitsFunction(callback))
                eval(callback + "();")
            else
                alert("回调函数无法执行:" + callback + ".");
        }
    });
}
//是否存在指定函数
function isExitsFunction(funcName) {
    try {
        if (typeof(eval(funcName)) === "function") {
            return true;
        }
    } catch(e) {}
    return false;
}
//是否存在指定变量
function isExitsVariable(variableName) {
    try {
        if (typeof(variableName) == "undefined") {
            return false;
        } else {
            return true;
        }
    } catch(e) {}
    return false;
}
function mainFrame() {
    this.loadMainMenuTop = loadMainMenuTop;
    this.loadMenuLeft = loadMainMenuLeft;
    this.loadSearchForm = loadSearchForm;
    this.loadSearchResultGrid = loadSearchResultGrid;
    this.loadTabLevelOne = loadTabLevelOne;
    this.loadTabLevelTwo = loadTabLevelTwo;
    this.topmenu_item_router = topmenu_item_router;

    this.loadPostDataById = loadPostDataById;
    
    this.loadMagWindow = loadMagWindow;
    this.loadPopWinMagWindow= loadPopWinMagWindow;


    this.loadSearchResultGridCustom = loadSearchResultGridCustom;
    this.init=cpc_mainInit;
    
//    //一级,二级导航事件
//    this.tabLevelOne = tabLevelOne_router;
//    this.tabLevelTwo = tabLevelTwo_router;
    //删除请求
    this.deleteById = deleteById;
    this.confirmById = confirmById;
    
}



function topmenu_item_router() {
    $("#topBar").on("click",".head_nav_l li",function () {
        $(".head_nav_l .on").each(function () {
            $(this).attr("class", "")
        });
        $(this).attr("class", "on");

        var funcName="topmenu_item_" + $(this).attr("f") + "_click";
        if(isExitsFunction(funcName))
        {	
        	$("#tabLevelOne").html("");
        	$("#tabLevelTwo").html("");
        	$("#searchForm").html("");
        	$("#searchResultGrid").html("");
        	$("#searchTermResultGrid").html("");
        	$("#searchScoreltGrid").html("");
        	$("#showresumeotherbtn").hide();
			$("#showresumeCRPbtn").hide();
			$("#showresumePSKbtn").hide();
			$("#showAwardsbtn").hide();
			$("#showscholarshipbtn").hide();
			$("#showWorkExperience").hide();
			$("#showEducationExperience").hide();
			$("#showTraining").hide();
			$("#showCertificate").hide();
			$("#showLanguage").hide();
			$("#showsPracticebtn").hide();
			$("#searchWorkExperienceGrid").html("");
			$("#searchEducationExperienceGrid").html("");
			$("#searchTrainingGrid").html("");
			$("#searchCertificateGrid").html("");
			$("#searchLanguageGrid").html("");
			$("#searchCRPltGrid").html("");
			$("#searchProSkillltGrid").html("");
			$("#searchAWARDSltGrid").html("");
			$("#searchscholarshipltGrid").html("");
			$("#searchPracticeltGrid").html("");
			$("#searchResumeOtherGrid").html("");
			$("div").removeClass("xgjl_2");
			$("div").removeClass("xgjl_3");
            eval(funcName+"('"+$(this).attr("f")+"');");
        }
        else
        {
            alert("尚未设置事件处理：" + funcName + ".");
        }

    });
}

function leftmenu_item_router()
{
    $(".s_nav li").click(function () {
        $(".s_nav .on").each(function(){
            $(this).attr("class","")
        });
        $(this).attr("class","on");
        
        var funcName=" leftmenu_item_" + $(this).attr("f") + "_click";
        if(isExitsFunction(funcName))
        {
        	$("#tabLevelOne").html("").hide();
        	$("#tabLevelTwo").html("").hide();
            eval(funcName+"('"+$(this).attr("f")+"','"+$(this).attr("qid")+"');");
        }
        else
        {
            alert("尚未设置事件处理：" + funcName + ".");
        }
    });
}
function tabLevelOne_router() {

    $("div#tabLevelOne li").click(function () {
        $("div#tabLevelOne .on").each(function(){
            $(this).attr("class","")
        });
        $(this).attr("class","on");
        var funcName=" tabLevelOne_" + $(this).attr("f") + "_click";
        $("#searchForm").html("");
        if(isExitsFunction(funcName))
        {
            eval(funcName+"('"+$(this).attr("f")+"');");
        }
        else
        {
            alert("尚未设置事件处理：" + funcName + ".");
        }

    });
}
function tabLevelTwo_router() {

    $("div#tabLevelTwo li").click(function () {
        $("div#tabLevelTwo .on").each(function(){
            $(this).attr("class","")
        });
        $(this).attr("class","on");
        var funcName=" tabLevelTwo_" + $(this).attr("f") + "_click";
        $("#searchForm").html("");
        if(isExitsFunction(funcName))
        {
            eval(funcName+"('"+$(this).attr("f")+"');");
        }
        else
        {
            alert("尚未设置事件处理：" + funcName + ".");
        }

    });
}
function cpc_mainInit() {
    $.ajaxSetup({
        error: function(jqXHR, textStatus, errorThrown){
            switch (jqXHR.status){
                case(500):
                    alert("服务器系统内部错误");//调用远程API失败
                    break;
                case(401):
                    alert("未登录");
                    break;
                case(403):
                    alert("无权限执行此操作");
                    break;
                case(408):
                    alert("请求超时");
                    break;
                default:
                    alert("未知错误");//本地出错，可以重定向重登录
            }
           },
        beforeSend: function(jqXHR)
        {
            $("#loading").show();
        },
        complete: function(jqXHR, textStatus)
        {
            $("#loading").hide();
        }
    });

    $('div.cd-popup2').on("mousedown",".titlePop",//弹窗修改，故修改
        function (event) {
            var isMove = true;
            var abs_x = event.pageX - $('.cd-popup2').offset().left;
            var abs_y = event.pageY - $('.cd-popup2').offset().top;
            $(document).on("mousemove",function (event) {
                    if (isMove) {
                        var obj = $('.cd-popup2');
                        obj.css({'left':event.pageX - abs_x, 'top':event.pageY - abs_y});
                    }
                }
            ).on("mouseup",
                function () {
                    isMove = false;
                }
            );
        }
    );

}
var cpcMain=new mainFrame();