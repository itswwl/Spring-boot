//$.ajax({
//	
//	type:"get",
//	url:"/springboot/item/findAll",
//	dataType:"json",
//	data:{},
//	success:function(data){
//		console.info(data);
//		console.info($("#all"));
//		for(var i = 0; i< data.length ; i++){
//			$("#all").val(data[0].ID+data[0].NAME);
//		}
//	}
//	
//});

//因为layout框架指向href时，只取html页面body中间的部分，所以该页面这样写即可
//有datagrid包含属性较多，所以尽量使用js的方式初始化datagrid框架
$(function() {
	$("#dg").datagrid({
		url : "/springboot/item/findAll2", // 指向一个一般处理程序或者一个控制器，返回数据要求是Json格式，直接赋值Json格式数据也可，我以demo中自带的Json数据为例，就不写后台代码了，但是我会说下后台返回的注意事项
		title : "数据展示表格",
		iconCls : "icon-add",
		fitColumns : false, // 设置为true将自动使列适应表格宽度以防止出现水平滚动,false则自动匹配大小
		// toolbar设置表格顶部的工具栏，以数组形式设置
		idField : 'id', // 标识列，一般设为id，可能会区分大小写，大家注意一下
		loadMsg : "正在努力为您加载数据", // 加载数据时向用户展示的语句
		pagination : true, // 显示最下端的分页工具栏
		rownumbers : true, // 显示行数 1，2，3，4...
		pageSize : 2, // 读取分页条数，即向后台读取数据时传过去的值
		pageList : [ 2, 4, 6 ], // 可以调整每页显示的数据，即调整pageSize每次向后台请求数据时的数据
		// 由于datagrid的属性过多，我就不每个都介绍了，如有需要，可以看它的API
		sortName : "ID", // 初始化表格时依据的排序 字段 必须和数据库中的字段名称相同
		sortOrder : "asc", // 正序
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				openDialog("add_dialog", "add");
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				openDialog("add_dialog", "edit");
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				delAppInfo();
			}
		} ],
		columns : [ [ {
			field : 'ID',
			title : 'ID',
			width : 100
		}, {
			field : 'NAME',
			title : 'NAME',
			width : 100,
			sortable : true
		},// sortable:true点击该列的时候可以改变升降序
		{
			field : 'addr',
			title : 'addr',
			width : 100,
		// 这里可以添加这样一个方法，使其显示数据得到改变
		// formatter: function (value, row, index) {
		// if (value == "0") {
		// return "普通角色";
		// } else {
		// return "特殊角色";
		// }
		// }
		} ] ]
	//这里之所以有两个方括号，是因为可以做成水晶报表形式，具体可看demo
	});
});