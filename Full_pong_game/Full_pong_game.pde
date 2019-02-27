// SETTTINGS
int ball_speed = 3; // Amount of pixles per update
int ball_speedy = 2; // Y axis ball speed


//250, 162.5 (Ball center position)

int points = 0;
int current_generation = 0;
int x = (int) random(25, 475);
int y = (int) random(25, 300);
int side = 0; //Side 0 = left, Side 1 = right
int sidey = 0; // Y Axis Side 0 = top, Side 1 = bottom

// Import libraries
import ddf.minim.*;  
Minim minim;
AudioSample sound;

void setup() {
  minim = new Minim (this);
  sound = minim.loadSample("Ping.wav", 128);

  size(500, 325);
  background(255, 205, 178);
  textSize(18);
}

void draw() {
  background(255, 205, 178);
  // Output the current generation of the screen
  fill(109, 104, 117);
  text("How many hits: " + current_generation, 10, 30);
  text("Points: " + points, 10, 60);

  // Check if the ball is going to fall of the window
  if (x > 475) {
    side = 1;
    sound.trigger();
    current_generation +=1;
  } else if (x < 25) {
    sound.trigger();
    side = 0;
    current_generation +=1;
  } else if (y > 300) {
    sound.trigger();
    sidey = 0;
    current_generation +=1;
  } else if (y < 25) {
    sound.trigger();
    sidey = 1; 
    current_generation +=1;
  }

  // Change the position of the ball
  if (side == 0 && sidey == 0) {
    x += ball_speed;
    y -= ball_speedy;
  } else if (side == 1 && sidey == 1) {
    x -= ball_speed; 
    y += ball_speedy;
  } else if (side == 0 && sidey == 1) {
    x += ball_speed;
    y += ball_speedy;
  } else if (side == 1 && sidey == 0) {
    x -= ball_speed; 
    y -= ball_speedy;
  }
  
  // Check if we should give points to the player
  
  // Left side
  if (x <= 23 && y > mouseY && y < mouseY + 50) {
   points++; 
  }
  
  // Right Side
  if (x >= 475 && y > mouseY && y < mouseY + 50) {
   points++; 
  }

  noStroke();
  fill(181, 131, 141);
  ellipse(x, y, 25, 25);

  // Draw out paddle (left)
  fill(255, 255, 255);
  rect(10, mouseY, 10, 50);
  
  // Draw out paddle (right)
  fill(255, 255, 255);
  rect(480, mouseY, 10, 50);

    println("Updated: " + x + "x " + y + "y");
}