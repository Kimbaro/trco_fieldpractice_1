var updateTable = function (carbonenRate_max, carbonenRate_min, device, exerciseIntensity_max, exerciseIntensity_min, heart, id, maximumHeart, name) {

    document.getElementById(device + "device").innerText = "( " + device + " )";
    document.getElementById(device + "heart").innerText = heart;
    document.getElementById(device + "carbonenRate_max").innerText = carbonenRate_max;
    document.getElementById(device + "carbonenRate_min").innerText = carbonenRate_min;
    document.getElementById(device + "exerciseIntensity_max").innerText = exerciseIntensity_max+"%";
    document.getElementById(device + "exerciseIntensity_min").innerText = exerciseIntensity_min+"%";

    document.getElementById(device + "name").innerText = name;
    // document.getElementById(device + "stableHeart").innerText=stableHeart;
    // document.getElementById(device + "id").innerText=id;

}