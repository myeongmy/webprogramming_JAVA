var target = document.querySelector('div');
target.style.left = "0px";
target.style.top = "0px";

target.addEventListener("mouseover", function(){
    target.style.left = parseInt(target.style.left) + 100 +"px";
    target.style.top = parseInt(target.style.top) + 100 + "px";
});