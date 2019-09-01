var updateTable = function (carbonenRate_max, carbonenRate_min, device, exerciseIntensity_max, exerciseIntensity_min, heart, id, maximumHeart, name, num) {

    // document.getElementById(device + "age").innerText = "( " + age + "세 )";
    // document.getElementById(device + "carbonenRate").innerText = carbonenRate;
    // document.getElementById(device + "exerciseIntensity").innerText = exerciseIntensity + "%";
    // document.getElementById(device + "maximumHeart").innerText = maximumHeart;

    document.getElementById(device + "name").innerText =  "No." + num + " " + name;
    document.getElementById(device + "device").innerText =  "( " + device + " )";
    document.getElementById(device + "carbonenRate_max").innerText = carbonenRate_max;
    document.getElementById(device + "carbonenRate_min").innerText = carbonenRate_min;
    document.getElementById(device + "exerciseIntensity_min").innerText = exerciseIntensity_min + "%";
    document.getElementById(device + "exerciseIntensity_max").innerText = exerciseIntensity_max + "%";
    document.getElementById(device + "heart").innerText = heart;
    document.getElementById(device + "name").innerText = "No." + num + " " + name;
    // document.getElementById(device + "stableHeart").innerText=stableHeart;
    // document.getElementById(device + "id").innerText=id;

}
