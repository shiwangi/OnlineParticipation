import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/15/13
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class magic {

        private static final int IN_BUFFER_SIZE = 1 << 16;
        private static final int OUT_BUFFER_SIZE = 1 << 16;
        private byte[] input = new byte[IN_BUFFER_SIZE];
        private int ix = IN_BUFFER_SIZE;
        private int bytesRead = ix;
        private byte[] output = new byte[OUT_BUFFER_SIZE];
        private int ox = 0;

        private void readMore() throws IOException {
            try {
                bytesRead = System.in.read(input, 0, IN_BUFFER_SIZE);
                if (bytesRead <= 0)
                    throw new RuntimeException();
                ix = 0;
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

        private void flushOut() {
            System.out.write(output, 0, ox);
            ox = 0;
        }

        private void append(String s) {
            char[] ca = s.toCharArray();
            for (int i = 0; i < ca.length; i++) {
                append(ca[i]);
            }
        }

        private void append(char c) {
            if (ox == OUT_BUFFER_SIZE)
                flushOut();
            output[ox++] = (byte) c;
        }

        private int nextInt() throws IOException {
            skipSpaces();
            int ret = 0;
            if (ix == bytesRead) {
                readMore();
            }
            int sign = 1;
            if (input[ix] == '-') {
                sign = -1;
                ix++;
            }
            while (true) {
                if (ix == bytesRead) {
                    try {
                        readMore();
                    } catch (RuntimeException e) {
                        return ret;
                    }
                }
                if (input[ix] < '0') {
                    break;
                }
                ret *= 10;
                ret += input[ix++] - '0';
            }
            return sign * ret;
        }

        private long nextLong() throws IOException {
            skipSpaces();
            long ret = 0;
            if (ix == bytesRead) {
                readMore();
            }
            int sign = 1;
            if (input[ix] == '-') {
                sign = -1;
                ix++;
            }
            while (true) {
                if (ix == bytesRead) {
                    try {
                        readMore();
                    } catch (RuntimeException e) {
                        return ret;
                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
                if (input[ix] < '0')
                    break;
                ret *= 10;
                ret += input[ix++] - '0';
            }
            return sign * ret;
        }

        private String nextLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (ix == bytesRead) {
                    readMore();
                }
                char c = (char) input[ix++];
                if (c == '\n')
                    break;
                sb.append(c);
            }
            return sb.toString();
        }

        private String nextString() throws IOException {
            try {
                skipSpaces();
            } catch (RuntimeException e) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (ix == bytesRead) {
                    try {
                        readMore();
                    } catch (RuntimeException e) {
                        return sb.toString();
                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
                if (input[ix] <= ' ')
                    break;
                sb.append((char) input[ix++]);
            }
            return sb.toString();
        }

        private String nextStringIncludeSpace32() throws IOException {
            try {
                skipSpaces();
            } catch (RuntimeException e) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (ix == bytesRead) {
                    try {
                        readMore();
                    } catch (RuntimeException e) {
                        return sb.toString();
                    }
                }
                if (input[ix] < ' ')
                    break;
                sb.append((char) input[ix++]);
            }
            return sb.toString();
        }

        private void nextCharArray(char[] ca, int len) throws IOException {
            skipSpaces();
            for (int i = 0; i < len; i++) {
                if (ix == bytesRead) {
                    readMore();
                }
                ca[i] = (char) input[ix++];
            }
        }

        private int charArrayLength;

        private void nextCharArray(char[] ca) throws IOException {
            skipSpaces();
            if (ix == bytesRead) {
                readMore();
            }
            charArrayLength = 0;
            ca[charArrayLength++] = (char) input[ix++];
            while (true) {
                if (ix == bytesRead) {
                    try {
                        readMore();
                    } catch (RuntimeException e) {
                        return;
                    }
                }
                char c = (char) input[ix++];
                if (c < '0')
                    break;
                ca[charArrayLength++] = c;
            }
        }

        private char nextCharSkipRest() throws IOException {
            skipSpaces();
            if (ix == bytesRead) {
                readMore();
            }
            char ret = (char) input[ix++];
            while (true) {
                if (ix == bytesRead) {
                    readMore();
                }
                if (input[ix++] <= ' ')
                    break;
            }
            return ret;
        }

        int cntSize;

        private char lastCharSkipRest() throws IOException {
            skipSpaces();
            if (ix == bytesRead) {
                readMore();
            }
            char ret = (char) input[ix++];
            cntSize = 1;
            while (true) {
                if (ix == bytesRead) {
                    readMore();
                }
                char c = (char) input[ix++];
                if (c <= ' ')
                    break;
                ret = c;
                cntSize++;
            }
            return ret;
        }

        private void skipSpaces() throws IOException {
            while (true) {
                if (ix == bytesRead) {
                    readMore();
                }
                if (input[ix] > ' ')
                    break;
                ix++;
            }
        }

        private char[] nn = new char[32];

        private void printLong(long n) {
            if (n == 0) {
                append('0');
            } else {
                if (n < 0) {
                    append('-');
                    n = -n;
                }
                int kk = 0;
                while (n > 0) {
                    nn[kk++] = (char) (n % 10 + '0');
                    n /= 10;
                }
                for (int i = kk - 1; i >= 0; i--) {
                    append(nn[i]);
                }
            }
        }

        private void printInt(int n) {
            if (n == 0) {
                append('0');
            } else {
                if (n < 0) {
                    append('-');
                    n = -n;
                }
                int kk = 0;
                while (n > 0) {
                    nn[kk++] = (char) (n % 10 + '0');
                    n /= 10;
                }
                for (int i = kk - 1; i >= 0; i--) {
                    append(nn[i]);
                }
            }
        }

        private void printDouble(double x, int p) {
            if (p == 0) {
                printLong(Math.round(x));
            } else {
                long pow = 1;
                for (int i = 0; i < p; i++) {
                    pow *= 10;
                }
                x *= pow;
                long t = Math.round(x);
                printLong(t / pow);
                append('.');
                long rem = t % pow;
                if (rem == 0) {
                    while (p-- > 0)
                        append('0');
                } else {
                    long tt = rem;
                    while (tt > 0) {
                        p--;
                        tt /= 10;
                    }
                    while (p-- > 0)
                        append('0');
                    printLong(rem);
                }
            }
        }

        private int parseInt(String s) {
            int result = 0;
            int sign = (s.charAt(0) == '-') ? -1 : 1;
            if (sign == -1) {
                s = s.substring(1);
            }
            if (s.charAt(0) == '+') {
                s = s.substring(1);
            }
            int i = 0, max = s.length();
            if (max > 0) {
                while (i < max) {
                    result *= 10;
                    result += s.charAt(i++) - 48;
                }
            }
            return sign * result;
        }

        private long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        private int powMod(int n, int k, int m) {
            if (k == 0)
                return 1;
            if ((k & 1) == 0) {
                int t = powMod(n, k / 2, m);
                return (t * t) % m;
            }
            return (n * powMod(n, k - 1, m)) % m;
        }

        private long[][] ID = { { 1, 0 }, { 0, 1 } };

        private long[][] pow(long[][] a, long k, long m) {
            if (k == 0)
                return ID;
            if ((k & 1) == 0) {
                long[][] t = pow(a, k / 2, m);
                return mul(t, t, m);
            }
            return mul(a, pow(a, k - 1, m), m);
        }

        private long[][] mul(long[][] a, long[][] b, long m) {
            return new long[][] {
                    { (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % m,
                            (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % m },
                    { (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % m,
                            (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % m } };
        }

        private final static int NN = 52; // max number of nodes
        private int[][] cap = new int[NN][NN]; // both
        private int[][] fnet = new int[NN][NN]; // ff
        private int[] q = new int[NN];
        private int[] prev = new int[NN];
        private int qf, qb;

        private int fordFulkerson(int n, int s, int t) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    fnet[i][j] = fnet[j][i] = 0;
                }
            }
            int flow = 0;
            while (true) {
                // find an augmenting path
                for (int i = 0; i < n; i++) {
                    prev[i] = -1;
                }
                qf = qb = 0;
                prev[s] = -2;
                q[qb++] = s;

                while (qb > qf && prev[t] == -1) {
                    int u = q[qf++];
                    int v = 0;
                    while (v < n) {
                        if (prev[v] == -1 && fnet[u][v] - fnet[v][u] < cap[u][v]) {
                            prev[v] = u;
                            q[qb++] = v;
                        }
                        v++;
                    }
                }
                // see if we are done
                if (prev[t] == -1) {
                    break;
                }
                // get the bottleneck capacity
                int bot = Integer.MAX_VALUE;
                int v = t;
                int u = prev[v];
                while (u >= 0) {
                    int tt = cap[u][v] - fnet[u][v] + fnet[v][u];
                    if (tt < bot)
                        bot = tt;
                    v = u;
                    u = prev[v];
                }
                // update the flow network
                v = t;
                u = prev[v];
                while (u >= 0) {
                    fnet[u][v] += bot;
                    v = u;
                    u = prev[v];
                }
                flow += bot;
            }
            return flow;
        }

        private void addEdge(int u, int v, int cp) {
            cap[u][v] += cp;
        }

        private void addEdgeUndirected(int u, int v, int cp) {
            addEdge(u, v, cp);
            addEdge(v, u, cp);
        }

        private int[] tmpSrt; // initialize me!

        private void sort(int array[], int begin, int end) {
            int mid;
            if (end - begin <= 1) {
                return;
            }
            mid = (begin + end) / 2;
            sort(array, begin, mid);
            sort(array, mid, end);
            merge(array, begin, mid, end);
        }

        private void merge(int[] array, int start, int mid, int end) {
            int i = start;
            int j = mid;
            int k = 0;
            while ((i < mid) && (j < end)) {
                if (array[i] <= array[j]) {
                    tmpSrt[k++] = array[i++];
                } else {
                    tmpSrt[k++] = array[j++];
                }
            }
            while (i < mid) {
                tmpSrt[k++] = array[i++];
            }
            while (j < end) {
                tmpSrt[k++] = array[j++];
            }
            for (i = start; i < end; i++) {
                array[i] = tmpSrt[i - start];
            }
        }

        public static void main(String[] args) throws IOException {
            new magic().work();
        }

        private void work() throws IOException {

            char[] s = new char[1 << 20];
            nextCharArray(s);
            int n = charArrayLength;
            int[] a = new int[n];
            int m = 0;
            for (int i = 0; i < s.length - 4; i++) {
                if (s[i] == 'm' && s[i + 1] == 'e' && s[i + 2] == 't'
                        && s[i + 3] == 'a' && s[i + 4] == 'l') {
                    a[m++] = i;
                    i += 4;
                }
            }
            long res = 0;
            int k = 0;
            for (int i = 0; i < s.length - 9; i++) {
                if (s[i] == 'h' && s[i + 1] == 'e' && s[i + 2] == 'a'
                        && s[i + 3] == 'v' && s[i + 4] == 'y') {
                    i += 4;
                    while (k < m && a[k] < i)
                        k++;
                    if (k == m)
                        break;
                    res += m - k;
                }
            }
            printLong(res);
            append('\n');

            if (ox > 0)
                flushOut();
            System.out.close();
        }

    }

