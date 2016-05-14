    package softwareEnginering;

    // BinaryHeap class
    //
    // CONSTRUCTION: with optional capacity (that defaults to 100)
    //
    // ******************PUBLIC OPERATIONS*********************
    // void insert( x )       --> Insert x
    // Comparable deleteMin( )--> Return and remove smallest item
    // Comparable findMin( )  --> Return smallest item
    // boolean isEmpty( )     --> Return true if empty; else false
    // boolean isFull( )      --> Return true if full; else false
    // void makeEmpty( )      --> Remove all items
    // ******************ERRORS********************************
    // Throws Overflow if capacity exceeded

/**
 *
 * @author zeev feldbeine
 * * Copyright -  Zeev feldbeine
 */
    
    public class MinHeap
    {
       private static final int DEFAULT_CAPACITY = 10000;

        private int currentSize;      // Number of elements in heap
        private long [] array; // The heap array
        private String[] array2;
        /**
         * Construct the binary heap.
         */
        public MinHeap( )
        {
            this( DEFAULT_CAPACITY );
        }

        /**
         * Construct the binary heap.
         * @param capacity the capacity of the binary heap.
         */
        public MinHeap( int capacity )
        {
            currentSize = 0;
            array = new long[ capacity + 1 ];
            array2=new String[capacity + 1];

        }

        /**
         * Insert into the priority queue, maintaining heap order.
         * Duplicates are allowed.
         * @param x the item to insert.
         * @exception Overflow if container is full.
         */
        public void insert( long x, String id ) throws Exception
        {
            if( isFull() )
            {
                System.out.println("the heap is full mtf");
               throw new Exception();
            }

                // Percolate up
            int hole = ++currentSize;
            for( ; hole > 1 && x-( array[ hole / 2 ] ) < 0; hole /= 2 ){
                array[ hole ] = array[ hole / 2 ];
                array2[hole]=array2[hole/2];
            }
            array[ hole ] = x;
            array2[hole]=id;
           // System.out.print(" "+array[0][hole]+"/"+array[1][hole]);
        }

        /**
         * Find the smallest item in the priority queue.
         * @return the smallest item, or null, if empty.
         */
        public long findMin( )
        {
            if( isEmpty( ) )
                return -1;
            return array[1];
        }
        public String findMin2()
        {
             if( isEmpty( ) )
                return "";
             return array2[1];
        }

        /**
         * Remove the smallest item from the priority queue.
         * @return the smallest item, or null, if empty.
         */
        public String deleteMin( )
        {
            if( isEmpty( ) )
                return "";

            long minItem = findMin();
            String minId=findMin2();
             // System.out.println("the dele"+minId+"the fac"+minItem);
            array[ 1 ] = array[ currentSize ];
            array2[1]=array2[currentSize--];
            percolateDown( 1 );
           // return minItem;
            return minId;
        }

        /**
         * Establish heap order property from an arbitrary
         * arrangement of items. Runs in linear time.
         */
        private void buildHeap( )
        {
            for( int i = currentSize / 2; i > 0; i-- )
                percolateDown( i );
        }

        /**
         * Test if the priority queue is logically empty.
         * @return true if empty, false otherwise.
         */
        public boolean isEmpty( )
        {
            return currentSize == 0;
        }

        /**
         * Test if the priority queue is logically full.
         * @return true if full, false otherwise.
         */
        public boolean isFull( )
        {
            return currentSize == array.length - 1;
        }

        /**
         * Make the priority queue logically empty.
         */
        public void makeEmpty( )
        {
            currentSize = 0;
        }


        /**
         * Internal method to percolate down in the heap.
         * @param hole the index at which the percolate begins.
         */
        private void percolateDown( int hole )
        {
/* 1*/      int child;
/* 2*/      long tmp = array[ hole ];
            String tmpl=array2[hole];

/* 3*/      for( ; hole * 2 <= currentSize; hole = child )
            {
/* 4*/          child = hole * 2;
/* 5*/          if( child != currentSize &&
/* 6*/                  array[child+1]-(array[child])<0)
/* 7*/              child++;
/* 8*/          if(array[child]-(tmp)<0)
/* 9*/              {
                        array[hole] = array[child];
                        array2[hole]=array2[child];
                    }
                else
/*10*/              break;
            }
/*11*/      array[hole] = tmp;
            array2[hole]=tmpl;

        }
       public void printHeap()
       {
            for(int i=0;i<3;i++)
                System.out.print(" "+array[i]+"/"+this.deleteMin());
            System.out.println("");
       }


    }