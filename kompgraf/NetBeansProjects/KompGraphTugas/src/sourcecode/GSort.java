package sourcecode;

// Joseph Bergin
// Pace University
// April, 1996
// Updated for Java 2 events April 2002
// Note that the sorts are artificially slowed to permit the process to be viewed
// more easily. 
import java.util.Random;
import java.lang.Math;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

class BubbleSorter implements Runnable {

    GSort g;

    public BubbleSorter(GSort s) {
        g = s;
    }

    public synchronized void run() {
        g.bubbleSort();
    }
}

class SelectionSorter implements Runnable {

    GSort g;

    public SelectionSorter(GSort s) {
        g = s;
    }

    public synchronized void run() {
        g.selectionSort();
    }
}

class QuickSorter implements Runnable {

    GSort g;
    int first, last;

    public QuickSorter(GSort gs, int f, int l) {
        g = gs;
        first = f;
        last = l;
    }

    public synchronized void run() {
        g.quickSort(first, last);
    }
}

public class GSort extends Applet {

    private static final int size = 400;
    private static final int m = 300;
    private static final int height = m + 50;
    private Random r = new Random();
    private Button randomArrayB;
    private Button nearlySortedB;
    private Button bubbleSortB;
    private Button selectionSortB;
    private Button quickSortB;
    private Graphics g;
    private Thread ActionThread = null;

    private int a[] = new int[size];
    private Color c[] = new Color[size];

    private void change(int i, int R) {
        Color oldColor = g.getColor();
        g.setColor(this.getBackground());
        g.fillRect(30 + i, height + 1 - a[i], 2, 2);
        g.setColor(c[i]);
        g.fillRect(30 + i, height + 1 - R, 2, 2);
        a[i] = R;
        g.setColor(oldColor);
    }

    private void swap(int i, int j) {
        int t = a[i];
        change(i, a[j]);
        change(j, t);
    }

    private void clear() {
        int i;
        for (i = 0; i < size; ++i) {
            g.clearRect(30 + i, height + 1 - a[i], 2, 2);
            a[i] = 0;
        }
    }

    private synchronized void randomArray() {
        int i;
        clear();
        for (i = 0; i < size; ++i) {
            a[i] = 0;
            change(i, Math.abs(r.nextInt()) % m + 1);
        }
    }

    private synchronized void nearlySortedArray() {
        int i, j;
        clear();
        for (i = 0; i < size; ++i) {
            a[i] = i / 4 * 3;
        }
        for (i = 0; i < 5; ++i) {
            for (j = 1; j < size; ++j) {
                if (Math.abs(r.nextInt()) % 2 == 0) {
                    swap(j - 1, j);
                }
                if (Math.abs(r.nextInt()) % 100 == 0) {
                    swap(i, Math.abs(r.nextInt()) % size);
                }
            }
        }
    }

    private void delay(int quantum) {
        try {
            Thread.sleep(quantum);
        } catch (InterruptedException i) {
        }
    }

    synchronized void bubbleSort() // obsolete
    // The largest so far on a pass is shown in red.
    {
        int i, j;
        Color t;
        for (i = 0; i < size; ++i) {
            for (j = 0; j < size - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    c[j] = Color.black;
                    c[j + 1] = Color.red;
                    swap(j, j + 1);
                }
                c[size - i - 1] = Color.black;
                change(size - i - 1, a[size - i - 1]);
            }
        }
    }

    synchronized void selectionSort() // obsolete
    // The location of the smallest seen on an inner pass is in red.
    {
        int i, j, small, s;
        for (i = 0; i < size - 1; ++i) {
            s = i;
            c[s] = Color.red;
            change(s, a[s]);
            small = a[s];
            for (j = i + 1; j < size; ++j) {
                if (a[j] < small) {
                    c[s] = Color.black;
                    change(s, a[s]);
                    s = j;
                    c[s] = Color.red;
                    change(s, a[s]);
                    small = a[s];
                    delay(5);
                }
            }
            c[s] = Color.black;
            change(s, a[i]);
            c[i] = Color.black;
            change(i, small);
        }
    }

    synchronized void quickSort(int L, int U) {
        int i, T, lastLow;
        int quantum = 5;
        if (L < U) {
            T = a[L];
            lastLow = L;
            for (i = L + 1; i <= U; ++i) {
                if (a[i] < T) {
                    lastLow++;
                    swap(lastLow, i);
                }
            }
            swap(L, lastLow);
            delay(quantum);
            quickSort(L, lastLow - 1);
            quickSort(lastLow + 1, U);
        }
    }

    class BubbleListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ActionThread = new Thread(new BubbleSorter(GSort.this));
            ActionThread.start();
        }
    }

    class SelectionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ActionThread = new Thread(new SelectionSorter(GSort.this));
            ActionThread.start();
        }
    }

    class QuickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ActionThread = new Thread(new QuickSorter(GSort.this, 0, size - 1));
            ActionThread.start();
        }
    }

    class RandomListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            randomArray();
        }
    }

    class NearlySortedListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            nearlySortedArray();
        }
    }

    public void init() {
        setLayout(new BorderLayout());
        Label L = new Label("Click an array type, then a sort type.");
        L.setFont(new Font("Times", Font.BOLD, 12));
        add("North", L);
        Panel P = new Panel();
        randomArrayB = new Button("Random Array");
        randomArrayB.addActionListener(new RandomListener());
        nearlySortedB = new Button("Nearly Sorted Array");
        nearlySortedB.addActionListener(new NearlySortedListener());
        bubbleSortB = new Button("Bubble Sort");
        bubbleSortB.addActionListener(new BubbleListener());
        selectionSortB = new Button("Selection Sort");
        selectionSortB.addActionListener(new SelectionListener());
        quickSortB = new Button("Quick Sort");
        quickSortB.addActionListener(new QuickListener());
        P.add(randomArrayB);
        P.add(nearlySortedB);
        P.add(bubbleSortB);
        P.add(selectionSortB);
        P.add(quickSortB);
        add("South", P);

        int i;
        for (i = 0; i < size; ++i) {
            a[i] = 0;
            c[i] = Color.black;
        }
        g = getGraphics();
    }

    public void paint(Graphics g) {
        for (int i = 0; i < size; ++i) {
            Color oldColor = g.getColor();
            g.setColor(this.getBackground());
            g.fillRect(30 + i, height + 1 - a[i], 2, 2);
            g.setColor(c[i]);
            g.fillRect(30 + i, height + 1 - a[i], 2, 2);
            g.setColor(oldColor);
        }
    }

}
