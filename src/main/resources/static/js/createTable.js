var createTable = function (carbonenRate_max, carbonenRate_min, device, exerciseIntensity_max, exerciseIntensity_min, heart, id, maximumHeart, name, num) {
    //테이블 생성 START
    // var people = getParameterByName("people");

    // id에 i값 더하는거는 임시
    var container = window.document.getElementById("wrapper");

    var db_device_name = device;
    // for (var i = 0; i < people; i++) {
    //테이블 담을 div
    var container_item = document.createElement('div');
    //고객 데이터 id
    var db_item_id = document.createElement('span');
    db_item_id.appendChild(document.createTextNode(id));
    db_item_id.setAttribute("display", "none");

    var ca_table = document.createElement('table');
    ca_table.setAttribute("id", db_device_name + "_table");

    // 1행 START
    var ca_tr1 = document.createElement('tr');
    ca_tr1.setAttribute("id", db_device_name + "_head_tr");

    var ca_td1 = document.createElement('td');
    ca_td1.setAttribute("id", db_device_name + "_head_td");
    ca_td1.setAttribute("colspan", "2");

    var ca_td1_span_name = document.createElement('span');
    ca_td1_span_name.setAttribute("id", db_device_name + "_head_name");
    var createName = document.createElement("span");
    createName.setAttribute("id", db_device_name + "name");
    createName.innerText = "No." + num + " " +name;
    createName.style.font = "18px bold";
    ca_td1_span_name.appendChild(createName);

    var ca_td1_span_device = document.createElement('span');
    ca_td1_span_device.setAttribute("id", db_device_name + "_head_device");
    var createDevice = document.createElement("span");
    createDevice.setAttribute("id", db_device_name + "device");
    createDevice.innerText = "( " + device + " )";
    ca_td1_span_device.appendChild(createDevice);

    ca_td1.appendChild(ca_td1_span_name);
    ca_td1.appendChild(ca_td1_span_device);

    ca_tr1.appendChild(ca_td1);
    // 1행 END

    //2행 START
    var ca_tr2 = document.createElement('tr');
    ca_tr2.setAttribute("id", db_device_name + "_body_tr");

    var ca_td2 = document.createElement('td');
    ca_td2.setAttribute("id", db_device_name + "_body_td");
    ca_td2.setAttribute("colspan", "2");

    var createHeart = document.createElement("span");
    createHeart.setAttribute("id", db_device_name + "heart");
    createHeart.appendChild(document.createTextNode(heart));
    createHeart.style.fontSize = "80px";
    createHeart.innerText = heart;

    ca_td2.appendChild(createHeart);
    ca_tr2.appendChild(ca_td2);
    //2행 END

    //3행 START
    var ca_tr3 = document.createElement('tr');
    ca_tr3.setAttribute("id", db_device_name + "_foot_tr");

    var ca_td3_1 = document.createElement('td');
    ca_td3_1.setAttribute("id", db_device_name + "_foot_td_1");
    var ca_td3_span_max_rate = document.createElement('span');
    ca_td3_span_max_rate.setAttribute("id", db_device_name + "carbonenRate_max");
    ca_td3_span_max_rate.style.fontSize= "20px";
    ca_td3_span_max_rate.innerText = carbonenRate_max;
    // var ca_td3_span_max_rate_icon = document.createElement('img');
    // ca_td3_span_max_rate_icon.setAttribute("src", "icon/carbonenRate_max.svg");
    // ca_td3_span_max_rate_icon.style.cssFloat = "left";
    // ca_td3_1.appendChild(ca_td3_span_max_rate_icon);
    ca_td3_1.appendChild(ca_td3_span_max_rate);

    var ca_td3_2 = document.createElement('td');
    ca_td3_2.setAttribute("id", db_device_name + "_foot_td_2");
    var ca_td3_span_min_rate = document.createElement('span');
    ca_td3_span_min_rate.setAttribute("id", db_device_name + "carbonenRate_min");
    ca_td3_span_min_rate.style.fontSize = "20px";
    ca_td3_span_min_rate.innerText = carbonenRate_min;
    // var ca_td3_span_min_rate_icon = document.createElement('img');
    // ca_td3_span_min_rate_icon.setAttribute("src", "/icon/carbonenRate_min.svg");
    // ca_td3_span_min_rate_icon.style.cssFloat = "left";
    // ca_td3_2.appendChild(ca_td3_span_min_rate_icon);
    ca_td3_2.appendChild(ca_td3_span_min_rate);

    ca_tr3.appendChild(ca_td3_2);
    ca_tr3.appendChild(ca_td3_1);
    //3행 END

    //4행 START
    var ca_tr4 = document.createElement('tr');
    ca_tr4.setAttribute("id", db_device_name + "_foot_tr2");

    var ca_td4_1 = document.createElement('td');
    ca_td4_1.setAttribute("id", db_device_name + "_foot_td2_1");
    var ca_td4_1_exerciseIntensity_min = document.createElement('span');
    ca_td4_1_exerciseIntensity_min.setAttribute("id", db_device_name + "exerciseIntensity_min");
    ca_td4_1_exerciseIntensity_min.style.fontSize = "20px";
    ca_td4_1_exerciseIntensity_min.innerText = exerciseIntensity_min + "%";
    // var ca_td4_1_exerciseIntensity_min_icon = document.createElement('img');
    // ca_td4_1_exerciseIntensity_min_icon.setAttribute("src", "/icon/minimumHeart.svg");
    // ca_td4_1_exerciseIntensity_min_icon.style.cssFloat = "left";
    // ca_td4_1.appendChild(ca_td4_1_exerciseIntensity_min_icon);
    ca_td4_1.appendChild(ca_td4_1_exerciseIntensity_min);

    var ca_td4_2 = document.createElement('td');
    ca_td4_2.setAttribute("id", db_device_name + "_foot_td2_2");
    var ca_td4_2_exerciseIntensity_max = document.createElement('span');
    ca_td4_2_exerciseIntensity_max.setAttribute("id", db_device_name + "exerciseIntensity_max");
    ca_td4_2_exerciseIntensity_max.style.fontSize = "20px";
    ca_td4_2_exerciseIntensity_max.innerText = exerciseIntensity_max + "%";
    // var ca_td4_2_exerciseIntensity_max_icon = document.createElement('img');
    // ca_td4_2_exerciseIntensity_max_icon.setAttribute("src", "/icon/minimumHeart.svg");
    // ca_td4_2_exerciseIntensity_max_icon.style.cssFloat = "left";
    // ca_td4_2.appendChild(ca_td4_2_exerciseIntensity_max_icon);
    ca_td4_2.appendChild(ca_td4_2_exerciseIntensity_max);

    ca_tr4.appendChild(ca_td4_1);
    ca_tr4.appendChild(ca_td4_2);


    //4행 END

    //주입 START
    ca_table.appendChild(ca_tr1);
    ca_table.appendChild(ca_tr2);
    ca_table.appendChild(ca_tr3);
    ca_table.appendChild(ca_tr4);
    //주입 END
    container_item.appendChild(ca_table);
    container.appendChild(container_item);

//    }
}