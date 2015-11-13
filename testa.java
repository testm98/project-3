///PROJECT 3//

//MATT TESTA//
 
 Ball a,b,c,d,e;
 Bird bluejay;
 float x,y; 
 
 String title= "Project 3";
 String author= "Matthew Testa";
 String name="";
 
 float left=50, right=850, top=250, bottom=550; //TABLE BOUNDARIES
 float middle= (left+right)/2;
 boolean wall=true;
 int frame;
 int tableRed=180, tableGreen=220, tableBlue=120; //COLOR OF TABLE

 
 
 void setup() {
   size(900,750);
   a= new Ball();
   a.r=255;
   a.name= "1";
   
   b= new Ball();
   b.g=255;
   b.name= "2";
   
   c= new Ball();
   c.r=230;
   c.g=240;
   c.b=180;
   c.name= "3";
   
   d= new Ball();
   d.r=120;
   d.g=140;
   d.b=240;
   d.name= "4";
   
   e= new Ball();
   e.r=0;
   e.g=0;
   e.b=0;
   
   bluejay= new Bird();
   jay.b=255;
   
 
  }

 
 
 void draw() {
   background(220,160,120);
   rectMode( CORNERS );
   table( left, top, right, bottom);
   balls();
   bird();
   buttons();
 }
 
 void table( float left, float top, float right, float bottom ) {
   fill( tableRed, tableGreen, tableBlue );
   strokeWeight(20);
   stroke( 110, 20, 10);
   rect(left-10, top-10, right+10, bottom+10);
   
   if (wall) {
     float middle= ( left + right)/2;
     stroke( 255,0,0,60);
     line( middle, top, middle, bottom);
    } 
  stroke(0);
  strokeWeight(1);
 }
 
 void balls() {
   collision( a,b );
   collision( a,c );
   collision( a,d );
   collision( a,e );
   
   collision( b,c);
   collision( b,d);
   collision(b,e);
   
   collision(c,d);
   collision(c,e);
   collision(d,e);
   
   
   a.move();
   b.move();
   c.move();
   d.move();
   e.move();
   
   a.show();
   b.show();
   c.show();
   d.show();
   e.show();
 }
   
   void collision( Ball a, Ball b) {
   if (a.hit (b.x,b.y) ) {
     tmp=a.dx; a.dx=b.dx; b.dx=tmp;
     tmp=a.dy; p.dy=q.dy; q.dy=tmp;
    }
   }
     
  void birds() {
    bluejay.move();
  }
  
  void keyPressed() {
  if (key == 'r') {
    a.reset();
    b.reset();
    c.reset();
    d.reset();
    e.reset();
  }
  }
 
 // objects //
 class Ball {
   float x,y, dx,dy;
   int r,g,b;
   String name="";
   
   void show() {
     fill(r,g,b);
     ellipse(x,y, 30, 30);
     fill(0);
     text( name, x-3,y);
 } 
   void move() {
     if (x>width || x<50) { dx= -dx; }
     if( y>height || y<250) { dy= -dy; }
   }
   void reset() {
     x = random( width/2, width-100 );
    y=  random( horizon+0, height-50 );
    dx=  random( 1,5 );
    dy=  random( 1,3 );
   }
 }  
 
 class Bird {
   float x=20, y=30, dx=5, dy=0.5;
   float w=40;
   int r,g,b;
   boolean wingUp=false;
   
   void show() {
    fill(r,g,b);
    triangle( x,y, x-w,y-5, x-w,y+5 );
    wingUp= int(frameCount/40) %2 >0;
    fill(180);
    if (wingUp) {
      triangle( x-w/3,y, x-w*2/3,y, x-w/2,y-40 );
    } else{
      triangle( x-w/3,y, x-w*2/3,y, x-w/2,y+40 );
    }
  }
  void move() {
    x=  x+dx;
    if (x>width) {    reset();  }
    y=  y+dy;
    if (x>0) {
      dy=  -dy;            
    }
  }
  boolean hit( float x, float y ) {
    if (  dist( x,y, this.x,this.y ) < 30 ) return true;
    else return false;
  }
  void reset() {
      x=0;
      y=  random( 50, horizon-30 );
      dx=  random( 2,5 );
  }
 
 void buttons() {
   rectMode( CORNER );
   strokeWeight(2);
   fill(180,100,200);
   rect(60,150,100,50);
   rect(250,150,100,50);
   rect(560,150,100,50);
   rect(750,150,100,50);
   fill(255);
   text("Reset 'R'", 80,180);
   text("Turn Off Wall 'W'", 255,180);
   text("Pink Table 'P'", 575, 180);
   text("Release Mouse 'M'", 750, 180);
 }
  
