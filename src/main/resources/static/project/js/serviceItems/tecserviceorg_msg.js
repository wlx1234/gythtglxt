(function () {
    require(['jquery', 'ajaxUtil', 'stringUtil', 'uploadImg', 'objectUtil', 'distpicker', 'urlUtil'],
        function ($, ajaxUtil, stringUtil, uploadImg, objectUtil, distpicker, urlUtil) {

            var url = "/industrialdevelop/tec-ser-org/selectbyorgcode";

            var opurl = "/industrialdevelop/tec-ser-org";

            var pathUrl = "/serviceItems/tecserviceorg_msg";

            var itemcode = stringUtil.getUUID();

            uploadImg.init();

            const editor = objectUtil.wangEditorUtil();

            $("#cancelBtn").click(function () {
                orange.redirect(pathUrl)
            });

            function generateParam() {
                var param = {};
                param.name = $("#name").val();
                param.projectName = $("#projectName").val();
                param.contacts = $("#contacts").val();
                param.phone = $("#phone").val();
                param.addressPro = $("#addressPro").val();
                param.addressCity = $("#addressCity").val();
                param.addressCountry = $("#addressCountry").val();
                param.address = $("#address").val();
                param.intruduce = editor.txt.html();
                param.itemcode = itemcode;
                return param;
            }

            $("#saveBtn").unbind('click').on('click', function () {
                var param = generateParam();
                param.status = 1;
                if (uploadImg.isUpdate()){
                    if (isUpdate()){
                        ajaxUtil.updateFile(itemcode,uploadImg.getFiles()[0],"undefined","undefined");
                    }else {
                        ajaxUtil.fileAjax(itemcode,uploadImg.getFiles()[0],"undefined","undefined")
                    }
                }
                ajaxUtil.myAjax(null, opurl, param, function (data) {
                    if (ajaxUtil.success(data)) {
                        orange.redirect(pathUrl);
                    } else {
                        alert(data.msg);
                    }
                }, true, "123", "put");
                return false;
            });

            $("#submitBtn").unbind('click').on('click', function () {
                var param = generateParam();
                param.status = 1;
                if (uploadImg.isUpdate()){
                    if (isUpdate()){
                        ajaxUtil.updateFile(itemcode,uploadImg.getFiles()[0],"undefined","undefined");
                    }else {
                        ajaxUtil.fileAjax(itemcode,uploadImg.getFiles()[0],"undefined","undefined")
                    }
                }
                ajaxUtil.myAjax(null, opurl, param, function (data) {
                    if (ajaxUtil.success(data)) {
                        orange.redirect(pathUrl)
                    } else {
                        alert(data.msg)
                    }
                }, true, "123", "put");
                return false;
            });

            var init = function () {
                ajaxUtil.myAjax(null,url,null,function (data) {
                    if(ajaxUtil.success(data)) {
                        var tempdata = data.data;
                        $("#name").val(tempdata.name);
                        $("#projectName").val(tempdata.projectName);
                        $("#contacts").val(tempdata.contacts);
                        $("#phone").val(tempdata.phone);
                        $("#distpicker").distpicker({
                            province: tempdata.addressPro,
                            city: tempdata.addressCity,
                            district: tempdata.addressCountry
                        });
                        $("#address").val(tempdata.address);
                        $(".w-e-text").html(tempdata.intruduce);
                        itemcode = tempdata.itemcode;
                        uploadImg.setImgSrc(tempdata.filePath)
                    }else{
                        alertUtil.error(data.msg)
                    }
                },null,"123","get")
            };
            init();

            function isUpdate() {
                return (urlUtil.getFullUrl().indexOf("/main#") != -1 || urlUtil.getFullUrl().indexOf("/main?") != -1)
            }
        })
})();
