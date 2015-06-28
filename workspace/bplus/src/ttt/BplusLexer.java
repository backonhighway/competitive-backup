package ttt;
// Generated from C:\Users\Okubo\Bplus.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BplusLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PLUS=2, MINUS=3, IDXPLUS=4, IDXMINUS=5, OUT=6, WHILEBEGIN=7, WHILEEND=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"WS", "'>'", "'<'", "'+'", "'-'", "'.'", "'['", "']'"
	};
	public static final String[] ruleNames = {
		"WS", "PLUS", "MINUS", "IDXPLUS", "IDXMINUS", "OUT", "WHILEBEGIN", "WHILEEND"
	};


	              int max = 10;
	              int index = 0;
	              int[] bfmemory = new int[max];
	              java.util.List<String> cmdlist = new java.util.ArrayList<String>();
	              

	public BplusLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Bplus.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\n(\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\25\n\2"+
		"\r\2\16\2\26\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\2\n\3\3\2\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\3\2\3\5"+
		"\2\13\f\17\17\"\"(\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\24\3\2\2\2\5\32\3\2\2"+
		"\2\7\34\3\2\2\2\t\36\3\2\2\2\13 \3\2\2\2\r\"\3\2\2\2\17$\3\2\2\2\21&\3"+
		"\2\2\2\23\25\t\2\2\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3"+
		"\2\2\2\27\30\3\2\2\2\30\31\b\2\2\2\31\4\3\2\2\2\32\33\7@\2\2\33\6\3\2"+
		"\2\2\34\35\7>\2\2\35\b\3\2\2\2\36\37\7-\2\2\37\n\3\2\2\2 !\7/\2\2!\f\3"+
		"\2\2\2\"#\7\60\2\2#\16\3\2\2\2$%\7]\2\2%\20\3\2\2\2&\'\7_\2\2\'\22\3\2"+
		"\2\2\4\2\26";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}