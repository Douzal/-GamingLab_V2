function Serpent()
{
    this.x = 0;
    this.y = 0;
    this.xspeed = 10;
    this.yspeed = 0;

    this.move = function()
    {
        var cadre = document.getElementById("cadre"),
            serpent = document.getElementById("serpent");

        serpent.style.display="block";

        this.x = this.x + this.xspeed;
        this.y = this.y + this.yspeed;

        if (this.x == getComputedStyle(cadre).width)
        {
            alert('Sortie de terrain en largeur');
        }

        if (this.y == getComputedStyle(cadre).height)
        {
            alert('Sortie de terrain en hauteur');
        }

        serpent.style.left = this.x +'px';
        serpent.style.top = this.y+'px';

        console.log(this.x+'px');
        console.log(serpent.style.left);
        
        window.requestAnimationFrame(move); 
    }
}