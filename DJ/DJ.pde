import ddf.minim.*;
Minim minim;  //as a member variable
AudioPlayer song;  //as a member variable

PImage pictureOfRecord; // Image varible
int i = 1;

void setup() {
  size(500,500); // Create the window
  pictureOfRecord = loadImage("SentrixLogo.jpg"); // Load Image
minim = new Minim(this);  //in the setup method
song = minim.loadFile("Buzz.mp3", 512);//in the setup method
  // pictureOfRecord.resize(0,0)
}

void draw() {
    rotateImage(pictureOfRecord,i);
    image(pictureOfRecord, 0, 0);
    i++;
}

void mousePressed() {
  song.play();
}

void rotateImage(PImage image, int amountToRotate) {
   translate(width/2, height/2);
   rotate(amountToRotate*TWO_PI/360);
   translate(-image.width/2, -image.height/2);
}
