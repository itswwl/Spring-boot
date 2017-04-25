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
    $.post(url, data,function(reponse) {
        $("#" + objId).html(reponse);
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
function loadMainMenuLeft(url,callback) {
    if(arguments.length==0) {
        url="/main/menu/left";
        callback=null;
    }else if(arguments.length==1)
    {
        callback=url;
        url="/main/menu/left";
    }
    loadPostDataById("left",url,null,callback);
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
    loadPostDataById("top",url,null,callback);
    
}
function loadSearchForm(url,data,callback) {
    loadPostDataById("searchForm",url,data,callback);
}
 
function loadSearchResultGrid(url,data,callback) {
    loadPostDataById("searchResultGrid",url,data,callback);
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
    popWin("pop");
}
function loadPopWinMagWindow(url,data,callback)
{
    loadMagWindow(url,data,function () {
        popWinMagWindow ();
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
function mainFrame() {
    this.loadMenuLeft = loadMainMenuLeft;
    this.loadMenuTop = loadMainMenuTop;
    this.loadSearchForm = loadSearchForm;
    this.loadSearchResultGrid = loadSearchResultGrid;
    this.loadTabLevelOne = loadTabLevelOne;
    this.loadTabLevelTwo = loadTabLevelTwo;
 
    this.loadPostDataById = loadPostDataById;
    
    this.loadMagWindow = loadMagWindow;
    this.loadPopWinMagWindow= loadPopWinMagWindow;
 
}

function topmenu_item_router() {
    $("#top li").click(function () {
//        $("#top .on").each(function () {
//            $(this).attr("class", "")
//        });
//        $(this).attr("class", "on");
 
        var funcName="topmenu_item_" + $(this).attr("f") + "_click";
        if(isExitsFunction(funcName))
        {
            eval(funcName+"('"+$(this).attr("f")+"','"+$(this).attr("id")+"');");
        }
        else
        {
            alert("尚未设置事件处理：" + funcName + ".");
        }
 
    });
}
 
function leftmenu_item_router()
{
    $("#left .left3 li").click(function () {
//        $(".s_nav .on").each(function(){
//            $(this).attr("class","")
//        });
//        $(this).attr("class","on");
        var funcName=" leftmenu_item_" + $(this).attr("f") + "_click";
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
 
function tabLevelOne_router() {
 
    $("div#tabLevelOne li").click(function () {
        $("div#tabLevelOne .on").each(function(){
            $(this).attr("class","")
        });
        $(this).attr("class","on");
        var funcName=" tabLevelOne_" + $(this).attr("f") + "_click";
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
var cpcMain=new mainFrame();
 