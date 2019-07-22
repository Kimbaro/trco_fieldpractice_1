var updateTable = function (age, carbonenRate, device, exerciseIntensity, heart, id, maximumHeart, name, stableHeart) {

    document.getElementById(device + "age").innerText = "( " + age + "세 )";
    document.getElementById(device + "carbonenRate").innerText = carbonenRate;
    document.getElementById(device + "exerciseIntensity").innerText = exerciseIntensity + "%";
    document.getElementById(device + "heart").innerText = heart;
    document.getElementById(device + "maximumHeart").innerText = maximumHeart;
    document.getElementById(device + "name").innerText = name;
    // document.getElementById(device + "stableHeart").innerText=stableHeart;
    // document.getElementById(device + "id").innerText=id;

}