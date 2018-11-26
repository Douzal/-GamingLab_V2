var start = document.getElementById("start"),
    stop = document.getElementById("stop"),

    canvas = document.getElementById("game"),
    widthCanvas = getComputedStyle(canvas).width,
    heightCanvas = getComputedStyle(canvas).height,
    ctx = canvas.getContext("2d"),
    startTime = (new Date()).getTime(),
    snake = new Snake(ctx,widthCanvas,heightCanvas,startTime);


start.addEventListener('click', function(){
    
    window.requestAnimationFrame(callback);

    function callback()
    {
        window.setTimeout(callback,1000/60);
    }

    // window.requestAnimFrame = (function(callback) {
    //     return window.requestAnimationFrame ||
    //     function(callback)
    //     {
    //         window.setTimeout(callback, 1000/60);
    //     };
    // })();
    
    snake.draw();

    setTimeout(function()
    {
        snake.move();
    }, 1000);
});





