package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes , write a method
 * to rotate the image by 90 degrees , can you do this in place?
 */
public class Question6 {

    public void rotateImage(byte[][]  image)
    {

        // each pixel is 4 bytes , so matrix size is N X 4N
        // clockwise rotate 90 degree
        //  (x , y ) -> (y , N-x)
        //  (y , N-x) -> (N-x , N-y)
        // (N-x , N-y) -> (N-y , x)
        // ( N-y , x) -> (x , y)
        //


        byte[] pixel = new byte[4];

        int size = image.length;


        for(int rowIndex = 0 ; rowIndex <= size/2 ; rowIndex++)
        {
            for(int colIndex = rowIndex; colIndex < size-rowIndex-1 ; colIndex++)
            {
                pixel[0] = image[rowIndex][4*colIndex];
                pixel[1] = image[rowIndex][4*colIndex+1];
                pixel[2] = image[rowIndex][4*colIndex+2];
                pixel[3] = image[rowIndex][4*colIndex+3];

                image[rowIndex][4*colIndex] = image[size -1-colIndex][4*rowIndex];
                image[rowIndex][4*colIndex+1] = image[size-1-colIndex][4*rowIndex+1];
                image[rowIndex][4*colIndex+2] = image[size-1-colIndex][4*rowIndex+2];
                image[rowIndex][4*colIndex+3] = image[size-1-colIndex][4*rowIndex+3];

                image[size-1-colIndex ][4*rowIndex] = image[size-1-rowIndex][4*(size -1 -colIndex)];
                image[size-1-colIndex ][4*rowIndex+1] = image[size-1-rowIndex][4*(size -1 -colIndex)+1];
                image[size-1-colIndex ][4*rowIndex+2] = image[size-1-rowIndex][4*(size -1 -colIndex)+2];
                image[size-1-colIndex ][4*rowIndex+3] = image[size-1-rowIndex][4*(size -1 -colIndex)+3];

                image[size-1-rowIndex][4*(size -1 -colIndex)] = image[colIndex][4*(size -1 -rowIndex)];
                image[size-1-rowIndex][4*(size -1 -colIndex)+1] = image[colIndex][4*(size -1 -rowIndex)+1];
                image[size-1-rowIndex][4*(size -1 -colIndex)+2] = image[colIndex][4*(size -1 -rowIndex)+2];
                image[size-1-rowIndex][4*(size -1 -colIndex)+3] = image[colIndex][4*(size -1 -rowIndex)+3];

                image[colIndex][4*(size -1 -rowIndex)] = pixel[0];
                image[colIndex][4*(size -1 -rowIndex)+1] = pixel[0];
                image[colIndex][4*(size -1 -rowIndex)+2] = pixel[0];
                image[colIndex][4*(size -1 -rowIndex)+3] = pixel[0];


            }
        }

    }

    @Test
    public void test1()
    {
        byte[][] image = new byte[][] {{1,1,1,1}};

        byte[][] expected = new byte[][] {{1,1,1,1}};


        Question6 question6 = new Question6();
        question6.rotateImage(image);
        assertEquals(expected , image);

    }

    @Test
    public void test2()
    {
        byte[][] image = new byte[][] {{1,1,1,1 , 2 ,2,2,2} ,
                {3,3,3,3,4,4,4,4}};

        byte[][] expected = new byte[][] {{3,3,3,3 , 1,1,1,1} ,
                {4,4,4,4,2,2,2,2}};


        Question6 question6 = new Question6();
        question6.rotateImage(image);
        assertEquals(expected , image);
    }

    @Test
    public void test3()
    {
        byte[][] image = new byte[][] {{1,1,1,1 , 2 ,2,2,2 , 3,3,3,3} ,
                {4,4,4,4,5,5,5,5 , 6,6,6,6},
                {7,7,7,7,8,8,8,8,9,9,9,9}};

        byte[][] expected = new byte[][] {{7,7,7,7 , 4,4,4,4 , 1,1,1,1} ,
                {8,8,8,8,5,5,5,5 , 2,2,2,2} ,
                {9,9,9,9 , 6,6,6,6, 3,3,3,3}};


        Question6 question6 = new Question6();
        question6.rotateImage(image);
        assertEquals(expected , image);
    }


    @Test
    public void test4()
    {
        byte[][] image = new byte[][] {{1,1,1,1 , 2 ,2,2,2 , 3,3,3,3 , 4,4,4,4} ,
                {5,5,5,5,        6,6,6,6 ,       7,7,7,7 ,     8,8,8,8 },
                {9,9,9,9,        10,10,10,10,    11,11,11,11 , 12,12,12,12} ,
                {13,13,13,13,    14,14,14,14,  15,15,15,15,    16,16,16,16}};

        byte[][] expected = new byte[][] {{13,13,13,13 , 9,9,9,9 , 5,5,5,5 , 1,1,1,1 } ,
                {14,14,14,14,   10,10,10,10 , 6,6,6,6 ,2,2,2,2 } ,
                {15,15,15,15 , 11,11,11,11, 7,7,7,7 , 3,3,3,3} ,
                {16,16,16,16,  12,12,12,12,  8,8,8,8, 4,4,4,4}};

        Question6 question6 = new Question6();
        question6.rotateImage(image);
        assertEquals(expected , image);

    }

    protected void assertEquals(byte[][] exoected , byte[][]actual)
    {
        for(int index = 0 ; index < exoected.length ; index++)
        {
            assertArrayEquals(exoected[index] , actual[index]);
        }

    }

}
