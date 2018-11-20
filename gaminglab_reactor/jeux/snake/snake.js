function Snake(context, widthCanvas, heightCanvas, startTime)
{
    this.myUnit = 
    {
        x : 0,
        y : 0,
        width : 20,
        height : 20,
        borderWidth : 2
    };
    this.context = context;
    this.widthCanvas = widthCanvas;
    this.heightCanvas = heightCanvas;
    this.startTime = startTime;
    // this.x=0;
    // this.y=0;
    // this.xspeed = 1;
    // this.yspeed = 0;

    this.draw = function()
    {
        this.context.beginPath();
        this.context.rect(this.myUnit.x, this.myUnit.y, this.myUnit.width, this.myUnit.height);
        this.context.fillStyle = "#3ed857";
        this.context.fill();
        this.context.lineWidth = this.myUnit.borderWidth;
        this.context.strokeStyle = "dimgray";
        this.context.stroke();
    }

    this.move = function()
    {
        // UPDATE

        var time = (new Date().getTime() - this.startTime),
            linearSpeed = 100,
            newX = linearSpeed * time / 1000;

        if (newX < this.widthCanvas - this.myUnit.width - this.myUnit.borderWidth / 2)
        {
            this.myUnit.x = newX;
        } 

        // CLEAR

        this.context.clearRect(0,0,this.widthCanvas,this.heightCanvas);

        this.draw();

        // REQUEST NEW FRAME

        // requestAnimFrame(function () 
        // {
        //     this.move();
        // });

        window.requestAnimationFrame(callback);
        
        function callback()
        {
            console.log('move');
            Snake.move;
            window.setTimeout(callback,1000/60);
        }


        // *** PUTAIN *** //

        // this.context.fillStyle = "#3ed857";
        // this.context.clearRect(this.x,this.y,20,10);
        
        // this.x = this.x + this.xspeed;
        // this.y = this.y + this.yspeed;

        // this.context.fillRect(this.x,this.y,20,10);

        // if (this.x == this.widthCanvas)
        // {
        //     this.x = 0; 
        // }
        // else if (this.y == this.heightCanvas)
        // {
        //     this.y = 0; 
        // }

        // setTimeout(?????,100);

        // *** PUTAIN *** //

        // while (this.x != width && this.y != height)
        // {
        //     console.log('clear');
        //     context.clearRect(this.x,this.y,20,10);
            
        //     this.x = this.x + this.xspeed;
        //     this.y = this.y + this.yspeed;
            
        //     console.log('fill');
        //     context.fillRect(this.x, this.y, 20,10);
        // }
    }

    this.show = function()
    {
        this.context.fillStyle = "#3ed857";
        this.context.fillRect(this.x , this.y , 20 , 10);
    }
}