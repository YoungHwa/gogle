$(document).ready(function sidebarjs_onload(){
	loadLoginInfo();
	loadMyProjects();
	listMembers();
	$("#projectListAll").onclick = function() {
		var event = new MouseEvent('projectManagement', {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});

		event.test = "okok";
		this.dispatchEvent(event);
	};
	$("#memberListAll").onclick = function() {
		var event = new MouseEvent('memberManagement', {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});

		event.test = "okok";
		this.dispatchEvent(event);
	};
});

function loadLoginInfo() {
	$.ajax("auth/loginInfo.do", {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				$("#userName").innerHTML = result.data.name;
				$("#userTel").innerHTML = result.data.tel;
				$("#userEmail").innerHTML = result.data.email;
				if (result.data.photoPath != undefined) {
					$("#memberPhoto").src = result.data.photoPath;
				} else {
					$("#memberPhoto").src = "images/test01.png";
				}
			} else {
				location.href = "auth/login.html";
			}
		},
		error: function(message) {
			alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
		}
	});
}

function loadMyProjects() {
	$.ajax("project/myprojects.do", {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				var projectsSection = $("#projects");
				var projects = result.data;
				var article = null;
				for (var i in projects) {
					article = $("<article>");
					article.innerHTML = 
						"<a href='/web13/project/view.do?no=" + 
						projects[i].no + "'>" +
						projects[i].title + "</a>";
					projectsSection.appendChild(article);
				}
			} else {
				alert("실행중 오류발생!");
				console.log(result.data);
			}
		},
		error: function(message) {
			alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
		}
	});

}


function listMembers() {
	$.ajax("member/members.do", {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				var membersSection = $("#members");
				var members = result.data;
				var article = null;
				for (var i in members) {
					article = $("<article>");
					article.innerHTML = 
						"<a href='/web13/member/list.do" + "</a>";
					membersSection.append(article);
				}
			} else {
				alert("실행중 오류발생!");
				console.log(result.data);
			}
		},
		error: function(message) {
			alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
		}
	});

}

//function listMember() {
//$.ajax("member/list.do", {
//type:"GET",
//success: function(result) {
//if(result.status == "success") {
//var members = result.data;
//$(".data-row").remove();
//var table = $("#memberTable");
//for (var i in members) {
//$("<tr>")
//.attr("class", "data-row")
//.append($("<td>").html( members[i].email ))
//.append($("<td>").append(
//$("<a>").html(members[i].name)
//.attr("href", "#")
//.attr("data-email", members[i].email)
//.click(function(event){
//viewDetailMember(this.attr("data-email"));
//})))
//.append($("<td>").html( members[i].tel ))
//.append($("<td>").html( members[i].blog ))
//.appendTo(table);
//}
//} else {
//alert("실행중 오류발생!");
//console.log(result.data);
//}
//},
//error: function(message) {
//alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
//}
//});
//}







