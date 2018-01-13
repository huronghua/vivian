$(function () {
    function AjaxPaginator(obj) {
        $.ajax({
            type:'GET',
            url: '/vivian/pagination',
            dataType: 'JSON',
            /*success*/complete: function (data) {
                var currentPage=data.currentPage|1;
                var totalPages=data.totalPages|10;
                var options = {
                    currentPage: currentPage, //当前页
                    totalPages: totalPages, //总页数
                    numberOfPages: 5, //设置控件显示的页码数
                    bootstrapMajorVersion: 3,//如果是bootstrap3版本需要加此标识，并且设置包含分页内容的DOM元素为UL,如果是bootstrap2版本，则DOM包含元素是DIV
                    useBootstrapTooltip: false,//是否显示tip提示框
                    itemTexts:function(type,page,current){//文字翻译
                        switch (type) {
                            case "first":
                                return "首页";
                            case "prev":
                                return "上一页";
                            case "next":
                                return "下一页";
                            case "last":
                                return "尾页";
                            case "page":
                                return page;
                        }
                    },
                    onPageClicked: function (event, originalEvent, type, page) {
                        $.ajax({
                            type:'GET',
                            url:'/vivian/pagination', //点击分页提交当前页码
                            dataType:'json',
                            data:{
                                'page':page
                            },
                            cache:false,
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                alert(XMLHttpRequest.status);
                            },
                            success:function(data){
                                if(data!=null){
                                    var table_data = '<tr style="font-size: initial"><td style="width: 200px;">姓名</td><td style="width: 200px;">性别</td>';
                                    $.each(data.user, function (index, item) {
                                        table_data += '<tr><td>' + item.name + '</td><td>' + item.sex + '</td>';
                                    });
                                    console.log(table_data);
                                    $("#user").html(table_data);
                                }
                            }
                        })
                    }
                };
                obj.bootstrapPaginator(options);
            }
        })
    }
    AjaxPaginator($("#pageLimit"));
});