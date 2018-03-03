<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/upload" method="post" enctype="multipart/form-data" onsubmit="return checkPhoto(this)">
    请选择头像:<input type="file" name="pictureFile" id="filesize">

    <input type="submit" value="上传">
</form>

<script>
    function checkPhoto(myupload) {
        var file = document.getElementById("filesize");
        var types = file.value.substr(file.value.lastIndexOf(".")+1).toLocaleLowerCase();
        if (file.value == "") {
            alert("请选择图片后上传");
            return false;
        } else if (types != "jpg" && types!="png" && types!="bmp" && types!="jpeg") {
            alert("只能上传jpg,jpeg,png,bmp格式的图片");
            return false;
        }
    }
</script>