package ttt;
// Generated from C:\Users\Okubo\Bplus.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BplusParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PLUS=2, MINUS=3, IDXPLUS=4, IDXMINUS=5, OUT=6, WHILEBEGIN=7, WHILEEND=8;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'>'", "'<'", "'+'", "'-'", "'.'", "'['", "']'"
	};
	public static final int
		RULE_eval = 0, RULE_bfexp = 1, RULE_whileblock = 2, RULE_bfstatement = 3;
	public static final String[] ruleNames = {
		"eval", "bfexp", "whileblock", "bfstatement"
	};

	@Override
	public String getGrammarFileName() { return "Bplus.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	              int max = 10;
	              int index = 0;
	              int[] bfmemory = new int[max];
	              java.util.List<String> cmdlist = new java.util.ArrayList<String>();
	              
	public BplusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public BfexpContext bfexp() {
			return getRuleContext(BfexpContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); bfexp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BfexpContext extends ParserRuleContext {
		public List<WhileblockContext> whileblock() {
			return getRuleContexts(WhileblockContext.class);
		}
		public WhileblockContext whileblock(int i) {
			return getRuleContext(WhileblockContext.class,i);
		}
		public BfstatementContext bfstatement(int i) {
			return getRuleContext(BfstatementContext.class,i);
		}
		public List<BfstatementContext> bfstatement() {
			return getRuleContexts(BfstatementContext.class);
		}
		public BfexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bfexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).enterBfexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).exitBfexp(this);
		}
	}

	public final BfexpContext bfexp() throws RecognitionException {
		BfexpContext _localctx = new BfexpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bfexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << IDXPLUS) | (1L << IDXMINUS) | (1L << OUT) | (1L << WHILEBEGIN))) != 0)) {
				{
				setState(12);
				switch (_input.LA(1)) {
				case PLUS:
				case MINUS:
				case IDXPLUS:
				case IDXMINUS:
				case OUT:
					{
					setState(10); bfstatement();
					}
					break;
				case WHILEBEGIN:
					{
					setState(11); whileblock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileblockContext extends ParserRuleContext {
		public TerminalNode WHILEBEGIN() { return getToken(BplusParser.WHILEBEGIN, 0); }
		public TerminalNode WHILEEND() { return getToken(BplusParser.WHILEEND, 0); }
		public BfstatementContext bfstatement(int i) {
			return getRuleContext(BfstatementContext.class,i);
		}
		public List<BfstatementContext> bfstatement() {
			return getRuleContexts(BfstatementContext.class);
		}
		public WhileblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).enterWhileblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).exitWhileblock(this);
		}
	}

	public final WhileblockContext whileblock() throws RecognitionException {
		WhileblockContext _localctx = new WhileblockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_whileblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); match(WHILEBEGIN);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << IDXPLUS) | (1L << IDXMINUS) | (1L << OUT))) != 0)) {
				{
				{
				setState(18); bfstatement();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24); match(WHILEEND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BfstatementContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(BplusParser.MINUS, 0); }
		public TerminalNode OUT() { return getToken(BplusParser.OUT, 0); }
		public TerminalNode PLUS() { return getToken(BplusParser.PLUS, 0); }
		public TerminalNode IDXPLUS() { return getToken(BplusParser.IDXPLUS, 0); }
		public TerminalNode IDXMINUS() { return getToken(BplusParser.IDXMINUS, 0); }
		public BfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bfstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).enterBfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BplusListener ) ((BplusListener)listener).exitBfstatement(this);
		}
	}

	public final BfstatementContext bfstatement() throws RecognitionException {
		BfstatementContext _localctx = new BfstatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bfstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			switch (_input.LA(1)) {
			case PLUS:
				{
				setState(26); match(PLUS);
				 bfmemory[index] += 1; 
				}
				break;
			case MINUS:
				{
				setState(28); match(MINUS);
				 bfmemory[index] -= 1; 
				}
				break;
			case IDXPLUS:
				{
				setState(30); match(IDXPLUS);
				 index += 1; 
				}
				break;
			case IDXMINUS:
				{
				setState(32); match(IDXMINUS);
				 
				                    if(index>0) { index -= 1; }
				                  
				}
				break;
			case OUT:
				{
				setState(34); match(OUT);
				 System.out.println(bfmemory[index]); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\n)\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\7\3\17\n\3\f\3\16\3\22\13\3\3\4\3\4"+
		"\7\4\26\n\4\f\4\16\4\31\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\'\n\5\3\5\2\6\2\4\6\b\2\2+\2\n\3\2\2\2\4\20\3\2\2\2\6\23\3"+
		"\2\2\2\b&\3\2\2\2\n\13\5\4\3\2\13\3\3\2\2\2\f\17\5\b\5\2\r\17\5\6\4\2"+
		"\16\f\3\2\2\2\16\r\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21"+
		"\5\3\2\2\2\22\20\3\2\2\2\23\27\7\t\2\2\24\26\5\b\5\2\25\24\3\2\2\2\26"+
		"\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32"+
		"\33\7\n\2\2\33\7\3\2\2\2\34\35\7\4\2\2\35\'\b\5\1\2\36\37\7\5\2\2\37\'"+
		"\b\5\1\2 !\7\6\2\2!\'\b\5\1\2\"#\7\7\2\2#\'\b\5\1\2$%\7\b\2\2%\'\b\5\1"+
		"\2&\34\3\2\2\2&\36\3\2\2\2& \3\2\2\2&\"\3\2\2\2&$\3\2\2\2\'\t\3\2\2\2"+
		"\6\16\20\27&";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}