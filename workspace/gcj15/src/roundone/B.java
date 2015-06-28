package roundone;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B implements Runnable {
	static final boolean PRODUCT_CODE = true;
	static final int NTHREAD = 4;
    static final String PROBLEM_NAME = "roundoneb";
    static final String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    static final String INPUT_FILE_NAME = "B-small-practice.in";
    static final String OUTPUT_FILE_NAME = "output.txt";
	
	static String INPATH = WORK_DIR + INPUT_FILE_NAME;
	static String OUTPATH = WORK_DIR + OUTPUT_FILE_NAME;
	
	static String INPUT = "";
	
	int k;
	int l;
	int s;
	String keyboard;
	String target;
	
	public void read() // not parallelized
	{
		k = ni();
		l = ni();
		s = ni();
		keyboard = in.next();
		target = in.next();
	}
	
	public int[] zAlgo(char[] str) {
		int n = str.length;
		int[] z = new int[n];
		if (n == 0) return z;
		z[0] = n;
		int l = 0, r = 0;
		for(int i = 1; i < n; i++){
			if (i > r) {
				l = r = i;
				while (r < n && str[r-l] == str[r]) r++;
				z[i] = r-l; r--;
			} else {
				int k = i-l;
				if (z[k] < r-i+1) {
					z[i] = z[k];
				} else {
					l = i;
					while (r < n && str[r-l] == str[r]) r++;
					z[i] = r-l; r--;
				}
			}
		}
		return z;
	}
	
	public void process() // parallelized!
	{
		// minimum bananas
		int minimum = 0;
		int[] z = zAlgo(target.toCharArray());
		int min = 1000;
		for (int i = 1; i < z.length; i++) {
			if (z[i] == z.length - i) {
				min = i; break;
			}
		}
		if (min != 1000) {
			int minlen = min+1;
			int occurence = s / minlen;
			int tarlen = l / minlen;
			minimum = occurence - tarlen + 1;
		} else {
			minimum = s / l;
		}
		
		int REP = 1_000_000;
		int count = 0;
		for (int x = 0; x < REP; x++) {

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s; i++) {
				int key = (int)(Math.random() * k);
				sb.append(keyboard.charAt(key));
			}
			String made = sb.toString();
			for (int i = 0; i <= s-l; i++) {
				String compare = made.substring(i, i+l);
				if (compare.equals(target)) count++;
			}
		}
		System.out.println(count);
		double expected = (double)count / (double)REP;
		
		
		
		double ans = 0.0;
		ans = minimum - expected;
		
		out.println(ans);
	}
	
	public static void preprocess()
	{
	}
	
	Scanner in;
	PrintWriter out;
	StringWriter sw;
	int caseNum;
	static List<Status> running = new ArrayList<Status>();
	
	@Override
	public void run()
	{
		long S = System.nanoTime();
		// register
		synchronized(running){
			Status st = new Status();
			st.id = caseNum;
			st.S = S;
			running.add(st);
		}
		process();
		// deregister
		synchronized(running){
			for(Status st : running){
				if(st.id == caseNum){
					running.remove(st);
					break;
				}
			}
		}
		long G = System.nanoTime();
		
		if(PRODUCT_CODE){
			System.err.println("case " + caseNum + " solved. [" + (G-S)/1000000 + "ms]");
			synchronized(running){
				StringBuilder sb = new StringBuilder("running : ");
				for(Status st : running){
					sb.append(st.id + ":" + (G-st.S)/1000000 + "ms, ");
				}
				System.err.println(sb);
			}
		}
	}
	
	private static class Status {
		public int id;
		public long S;
	}
	
	public B(int caseNum, Scanner in)
	{
		this.caseNum = caseNum;
		this.in = in;
		this.sw = new StringWriter();
		this.out = new PrintWriter(this.sw);
	}
	
	private int ni() { return Integer.parseInt(in.next()); }
	private long nl() { return Long.parseLong(in.next()); }
	private int[] na(int n) { int[] a = new int[n]; for(int i = 0;i < n;i++)a[i] = ni(); return a; }
	private double nd() { return Double.parseDouble(in.next()); }
	private void tr(Object... o) { if(!PRODUCT_CODE)System.out.println(Arrays.deepToString(o)); }
	
	public static void main(String[] args) throws Exception
	{
		long start = System.nanoTime();
		
		ExecutorService es = Executors.newFixedThreadPool(NTHREAD);
		CompletionService<B> cs = new ExecutorCompletionService<B>(es);
		
		if(PRODUCT_CODE){
			System.out.println("INPATH : " + INPATH);
			System.out.println("OUTPATH : " + OUTPATH);
		}
		Scanner in = PRODUCT_CODE ? new Scanner(new File(INPATH)) : new Scanner(INPUT);
		PrintWriter out = PRODUCT_CODE ? new PrintWriter(new File(OUTPATH)) : new PrintWriter(System.out);
		int n = in.nextInt();
		in.nextLine();
		
		preprocess();
		for(int i = 0;i < n;i++){
			B runner = new B(i+1, in);
			runner.read();
			cs.submit(runner, runner);
		}
		es.shutdown();
		String[] outs = new String[n];
		for(int i = 0;i < n;i++){
			B runner = cs.take().get(); // not ordered
			runner.out.flush();
			runner.out.close();
			outs[runner.caseNum-1] = runner.sw.toString();
		}
		for(int i = 0;i < n;i++){
			out.printf("Case #%d: ", i+1);
			out.append(outs[i]);
			out.flush();
		}
		
		long end = System.nanoTime();
		System.out.println((end - start)/1000000 + "ms");
		if(PRODUCT_CODE){
			System.out.println("INPATH : " + INPATH);
			System.out.println("OUTPATH : " + OUTPATH);
		}
	}
}
