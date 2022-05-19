    public class Kernel {
      float[][]kernel;

      /**Constructor takes the kernel that will be applied to the image
      *This implementation only allows 3x3 kernels
      */
      public Kernel(float[][]init) {
        kernel = init;
      }

      /**If part of the kernel is off of the image, return black, Otherwise
      *Calculate the convolution of r/g/b separately, and return that color\
      *if the calculation for any of the r,g,b values is outside the range
      *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
      */
      color calcNewColor(PImage img, int x, int y) {
        //Hint: start by always returning black.
        //This will let you test your apply method right away!
        float r = 0; 
        float g = 0; 
        float b = 0;
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            r += (kernel[i][j] * red(img.get(x+j-1,y+i-1))); 
            g += (kernel[i][j] * green(img.get(x+j-1,y+i-1))); 
            b += (kernel[i][j] * blue(img.get(x+j-1,y+i-1))); 
          }
        }
        if (r < 0){
          r = 0;
        }else if (r > 255){
          r = 255;
        }
        if (g < 0){
          g = 0;
        }else if (g > 255){
          g = 255;
        }
        if (b < 0){
          b = 0;
        }else if (b > 255){
          b = 255;
        }
        return color(r, g, b);
      }

      /**You must write this method that applies the kernel to the source,
        *and saves the data to the destination.*/
      void apply(PImage source, PImage destination) {
        for (int i = 1; i < source.width - 1; i++){
          for (int j = 1; j < source.height - 1; j++){
            destination.set(i, j, calcNewColor(source, i, j));
          }
        }
      }

    }
