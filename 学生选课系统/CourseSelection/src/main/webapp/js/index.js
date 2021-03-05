var useridEle = document.getElementById("userid");
var passwordEle = document.getElementById("password");
var roleRadio = document.getElementsByName("optionsRadios1");

function submitHandler() {

    if (!vali()) {
        return false;
    }

    var role = 'student';

    for (var i = 0; i < roleRadio.length; i++) {
        if (roleRadio[i].checked) {
            role = roleRadio[i].value;
        }
    }

    var action = null;
    if (role == 'student') {
        action = "/LoginHandler/studentlogin";
        useridEle.name = "sid";
        passwordEle.name = "spassword";
    } else if (role == 'teacher') {
        action = "/LoginHandler/teacherlogin";
        useridEle.name = "tid";
        passwordEle.name = "tpassword";
    } else {
        action = "/LoginHandler/adminlogin";
        useridEle.name = "aname";
        passwordEle.name = "apassword";
    }
    document.getElementById("login").action = action;

    return true;
}

function vali() {
    var valiObjs = createInputMsgObj([ 'userid', 'password' ])

    for (var i = 0; i < valiObjs.length; i++) {
        console.log(valiObjs[i].el.val())
        if (valiObjs[i].el.val() == null || valiObjs[i].el.val() == '') {
            valiObjs[i].el.css({
                "border-color" : "red"
            })
            console.log(valiObjs[i].el)
            var alertEl = $("<div style=\"position:fixed;top:1rem;right:1rem;\" class=\"alert alert-warning\">"
                + valiObjs[i].msg + "没有填写！" + "</h5></div>")
            $("body").append(alertEl);
            setTimeout(function() {
                alertEl.remove();
            }, 1000)
            return false;
        }
    }
    return true;
}

function createInputMsgObj(ids) {
    var objs = [];

    for (var i = 0; i < ids.length; i++) {

        var obj = {
            el : $("#" + ids[i]),
            msg : $("#" + ids[i]).attr('m')
        }
        objs.push(obj);
    }

    return objs;
}