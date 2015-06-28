package qual;
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

public class CopyOfMyTemplate implements Runnable {
	static final boolean LARGE = true;
	static final boolean PRODUCT_CODE = true;
	static final int NTHREAD = 2;
    static final String PROBLEM_NAME = "dijkstra";
    static final String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    static final String INPUT_FILE_NAME = "C-small-attempt1.in";
    static final String OUTPUT_FILE_NAME = "output.txt";
	
	static String INPATH = WORK_DIR + INPUT_FILE_NAME;
	static String OUTPATH = WORK_DIR + OUTPUT_FILE_NAME;
	
	static String INPUT = "";
	
	int l;
	int x;
	String base;
	
	public void read() // not parallelized
	{
		l = nextInt();
		x = nextInt();
		base = in.next();
	}
	
	public void process() // parallelized!
	{
		solve();
	}
	
    public void solve(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
			sb.append(base);
		}
        String s = sb.toString();
        int len = s.length();
        if (len < 3) {
        	out.println("NO");
        	return;
        }
        
        boolean isOK = false;
        int left = getIjkInt(s.charAt(0));
        if (left == 2) {
        	if(tryit(s.substring(1))) {
        		out.println("YES");
        		return;
        	}
        }
        for (int i = 1; i < len-1; i++) {
			left = quant(left, getIjkInt(s.charAt(i)));
	        if (left == 2) {
	        	if(tryit(s.substring(i+1))) {
	        		out.println("YES");
	        		return;
	        	}
	        }
		}
        
        String ans = isOK ? "YES" : "NO";
        out.println(ans);
    }
    
    public boolean tryit(String s) {
    	boolean ret = false;
    	int len = s.length();
    	if (len < 2) return false;
    	
        int mid = getIjkInt(s.charAt(0));
        if (mid == 3) {
        	if(tryright(s.substring(1))) {
        		return true;
        	}
        }
    	for (int i = 1; i < len-1; i++) {
			mid = quant(mid, getIjkInt(s.charAt(i)));
			if (mid == 3) {
				if(tryright(s.substring(i+1))) {
					return true;
				}
			}
		}
    	
    	return ret;
    }
    
    public boolean tryright(String s) {
    	int len = s.length();
    	int right = getIjkInt(s.charAt(0));
    	for (int i = 1; i < len; i++) {
			right = quant(right, getIjkInt(s.charAt(i)));
		}
    	return right == 4;
    }
    
    public int quant(int i1, int i2) {
    	int signed = 1;
    	if (i1*i2 < 0) signed = -1;
    	if (i1 < 0) i1 *= -1;
    	if (i2 < 0) i2 *= -1;
    	
    	int ret = 0;
    	if (i1 == 1) {
    		if (i2 == 1) ret = 1;
    		if (i2 == 2) ret = 2;
    		if (i2 == 3) ret = 3;
    		if (i2 == 4) ret = 4;
    	}
    	if (i1 == 2) {
    		if (i2 == 1) ret = 2;
    		if (i2 == 2) ret = -1;
    		if (i2 == 3) ret = 4;
    		if (i2 == 4) ret = -3;
    	}
    	if (i1 == 3) {
    		if (i2 == 1) ret = 3;
    		if (i2 == 2) ret = -4;
    		if (i2 == 3) ret = -1;
    		if (i2 == 4) ret = 2;
    	}
    	if (i1 == 4) {
    		if (i2 == 1) ret = 4;
    		if (i2 == 2) ret = 3;
    		if (i2 == 3) ret = -2;
    		if (i2 == 4) ret = -1;
    	}
    	return ret * signed;
    }
    
    public int getIjkInt(char c) {
    	if (c == '1') return 1;
    	if (c == 'i') return 2;
    	if (c == 'j') return 3;
    	else return 4;
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
	
	public CopyOfMyTemplate(int caseNum, Scanner in)
	{
		this.caseNum = caseNum;
		this.in = in;
		this.sw = new StringWriter();
		this.out = new PrintWriter(this.sw);
	}
	
	private int nextInt() { return Integer.parseInt(in.next()); }
	private long nl() { return Long.parseLong(in.next()); }
	private int[] na(int n) { int[] a = new int[n]; for(int i = 0;i < n;i++)a[i] = nextInt(); return a; }
	private double nd() { return Double.parseDouble(in.next()); }
	private void tr(Object... o) { if(!PRODUCT_CODE)System.out.println(Arrays.deepToString(o)); }
	
	public static void main(String[] args) throws Exception
	{
		long start = System.nanoTime();
		
		ExecutorService es = Executors.newFixedThreadPool(NTHREAD);
		CompletionService<CopyOfMyTemplate> cs = new ExecutorCompletionService<CopyOfMyTemplate>(es);
		
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
			CopyOfMyTemplate runner = new CopyOfMyTemplate(i+1, in);
			runner.read();
			cs.submit(runner, runner);
		}
		es.shutdown();
		String[] outs = new String[n];
		for(int i = 0;i < n;i++){
			CopyOfMyTemplate runner = cs.take().get(); // not ordered
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
