function checkForm() {
    var mGroupId = document.getElementById("group_id").value;
    var mMimeName = document.getElementById("mime_name").value;
    var mMimeYear = document.getElementById("mime_year").value;
    var mMimeArea = document.getElementById("mime_area").value;
    var mMimeSex = document.getElementById("mime_sex").value;
    var mMimeWXNum = document.getElementById("mime_wx_num").value;
    var mMimeInterest = document.getElementById("mime_interest").value;
    // var mYourYear = document.getElementById("your_year").value;
    var mYourArea = document.getElementById("year_area").value;
    var mYourInterest = document.getElementById("your_interest").value;


    if (mGroupId == "") {
        layer.msg('群id不能为空');
        return false;
    }
    if (mMimeName == "") {
        layer.msg('我的名字不能为空');
        return false;
    }
    if (mMimeYear == "") {
        layer.msg('我的年龄不能为空');
        return false;
    }
    if (mMimeArea == "") {
        layer.msg('我的籍贯不能为空');
        return false;
    }
    if (mMimeSex == "") {
        layer.msg('我的性别不能为空');
        return false;
    }
    return true;
}
