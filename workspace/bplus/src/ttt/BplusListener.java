package ttt;
// Generated from C:\Users\Okubo\Bplus.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BplusParser}.
 */
public interface BplusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BplusParser#bfstatement}.
	 * @param ctx the parse tree
	 */
	void enterBfstatement(@NotNull BplusParser.BfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BplusParser#bfstatement}.
	 * @param ctx the parse tree
	 */
	void exitBfstatement(@NotNull BplusParser.BfstatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BplusParser#bfexp}.
	 * @param ctx the parse tree
	 */
	void enterBfexp(@NotNull BplusParser.BfexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BplusParser#bfexp}.
	 * @param ctx the parse tree
	 */
	void exitBfexp(@NotNull BplusParser.BfexpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BplusParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(@NotNull BplusParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link BplusParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(@NotNull BplusParser.EvalContext ctx);

	/**
	 * Enter a parse tree produced by {@link BplusParser#whileblock}.
	 * @param ctx the parse tree
	 */
	void enterWhileblock(@NotNull BplusParser.WhileblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BplusParser#whileblock}.
	 * @param ctx the parse tree
	 */
	void exitWhileblock(@NotNull BplusParser.WhileblockContext ctx);
}