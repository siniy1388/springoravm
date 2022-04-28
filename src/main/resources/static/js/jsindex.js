var selectedVmId ;
var selectedVmInfo;
function openTab(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
    switch (cityName) { 
        case 'Servers': 
            loadServ();
            loadUsers();
            break;
        case 'Repos':    
            loadVms(); 
            break;
        case 'Network':
            loadCommands();
            break;
            
}
}

function loadCommands() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                var uservm = JSON.parse(this.responseText);
                var html = '<tr>\n' + 
                    '        <th>id</th>\n' +
                    '        <th>groop</th>\n' +
                    '        <th>command</th>\n' +
                    '        <th>nameR</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
                for (var i = 0; i < uservm.length; i++) {
                    var user = uservm[i];
                    console.log(user);
                    html = html + '<tr><td>' + user.id+ '</td>\n' +
                        '       <td>' + user.groop+ '</td>\n' +
                        '        <td>' + user.command + '</td>\n' +
                        '        <td>' + user.namer + '</td>' +
                        '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';

                }
                document.getElementById("commandList").innerHTML = html;
            }
                };
                xhttp.open("GET", "http://localhost:8080/commands/findAll", true);
                xhttp.send();
            }



function loadUsers() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var users = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>User id</th>\n' +
                    '        <th>User name</th>\n' +
                    '        <th>User login</th>\n' +
                    '        <th>User email</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
                for (var i = 0; i < users.length; i++) {
                    var user = users[i];
                    console.log(user);
                    html = html + '<tr><td>' + user.id + '</td>\n' +
                        '        <td>' + user.name + '</td>\n' +
                        '        <td>' + user.login + '</td>\n' +
                        '        <td>' + user.email + '</td>' +
                        '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';

                }
                document.getElementById("usersList").innerHTML = html;
            }
        };
        xhttp.open("GET", "http://localhost:8080/users/findAll", true);
        xhttp.send();
    }


    
function loadVms() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var usersvm = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>UserVm id</th>\n' +
                    '        <th>UserVm name</th>\n' +
                    '        <th>UserVm nameVm</th>\n' +
                    '        <th>UserVm cdVmSys</th>\n' +
                    '        <th>UserVm userid</th>\n' +
                    '        <th>UserVm cdvm</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
                for (var i = 0; i < usersvm.length; i++) {
                    var uservm = usersvm[i];
                    console.log(uservm);
                    html = html + '<tr><td>' + uservm.name + '</td>\n' +
                        '        <td>' + uservm.name + '</td>\n' +
                        '        <td>' + uservm.namevm + '</td>\n' +
                        '        <td>' + uservm.cdvmSystem + '</td>' +
                        '        <td>' + uservm.userid + '</td>' +
                        '        <td>' + uservm.cdvm + '</td>' +
                        '        <td><button onclick="deleteUser(' + uservm.id + ')">Delete</button></td></tr>';

                }
                document.getElementById("vmsList").innerHTML = html;
            }
        };
        xhttp.open("GET", "http://localhost:8080/usersvm/findAllVm", true);
        xhttp.send();
    }

  
    
    function loadServ() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var servers = JSON.parse(this.responseText);
                var html = '<tr >\n' +
                    '        <th>Server name</th>\n' +
                    '    </tr>';
                for (var i = 0; i < servers.length; i++) {
                    var server = servers[i];
                    console.log(server);
                    html = html + 
                        '        <tr onclick="getServerVms(\'' +server.id+ '\')"><td id=' + server.id + '>' + server.name + '</td>\n' +
                        '   </tr>';

                }
                document.getElementById("servList").innerHTML = html;
            }
        };
        xhttp.open("GET", "http://localhost:8080/ovmm_commands/ExecComndDto?command=list server", true);
        xhttp.send();
    }
    
    
    
    function getVmInfo(vmId) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var vminfo = this.responseText;
                var vparse = JSON.parse(vminfo);
                var html = '<tr>\n' +
                    '        <p>Vm Info</p>\n' +
                    '    </tr>';
//                for (var i = 0; i < servers.length; i++) {
//                    var server = servers[i];
                    console.log(vminfo);
                    html = html + 
                        '        <tr><p>' + vminfo + '</td>\n' +
                        '</tr>';

               // }
//                document.getElementById("vmInfo").innerHTML = html;
var modal = $modal({
  title: 'Текст заголовка',
  content: '<p>Содержимое модального окна...</p>',
  footerButtons: [
    { class: 'btn btn__cancel', text: 'Отмена', handler: 'modalHandlerCancel' },
    { class: 'btn btn__ok', text: 'ОК', handler: 'modalHandlerOk' }
  ]
});
            }
        };
        xhttp.open("GET", "http://localhost:8080/ovmm_commands/getVmInfo?vmId="+vmId, true);
        xhttp.send();
    }
    
    function getServerVms(vserverid){
//        console.log(vserverid);
//        alert("Hello");
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var vms = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>Vm name</th>\n' +
                    '        <th>Start Vm</th>\n' +
                    '    </tr>';
                for (var i = 0; i < vms.length; i++) {
                    var vmm = vms[i];
                    console.log(vmm);
                    html = html + 
                        '        <tr>' +
//                        '        <td onclick="getVmInfo(\'' + vmm.id + '\')" id=' + vmm.id + '>' + vmm.name + '</td>\n' +
                        '        <td onclick="saveSelectedVmId(\'' + vmm.id + '\')" id=' + vmm.id + '>' + vmm.name + '</td>\n' +
//                        '        <td><button onclick="startVm(\'' + vmm.id + '\')">start VM</button></td>'+
                        '        </tr>';

                }
                document.getElementById("vmList").innerHTML = html;
            }
        };
        xhttp.open("GET", "http://localhost:8080/ovmm_commands/getServerInfo?serverID=" +vserverid, true);
        xhttp.send();
    }
    
    function startVm(vmId){
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/ovmm_commands/startVm?vmId=" +vmId, true);
        xhttp.send();
    }
    
    function saveSelectedVmId(vmId){
        selectedVmId = vmId;
        
//        var xhttp = new XMLHttpRequest();
//        xhttp.onreadystatechange = function () {
//            if (this.readyState === 4 && this.status === 200) {
//                var vminfo = this.responseText;
//                var vparse = JSON.parse(vminfo);
//            }
//        };
//        xhttp.open("GET", "http://localhost:8080/userRole/findAll", true);
//        xhttp.send();
    }
  
    
  
