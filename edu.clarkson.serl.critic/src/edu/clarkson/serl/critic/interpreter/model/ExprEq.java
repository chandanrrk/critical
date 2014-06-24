/*
 * ExprEq.java
 * Jul 4, 2011
 *
 * CriticAL: A Critic for APIs and Libraries
 * 
 * Copyright (C) 2011 Chandan Raj Rupakheti & Daqing Hou, Clarkson University
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License 
 * as published by the Free Software Foundation, either 
 * version 3 of the License, or any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contact Us:
 * Chandan Raj Rupakheti <rupakhcr@clarkson.edu> 
 * Daqing Hou <dhou@clarkson.edu>
 * Clarkson University
 * Potsdam
 * NY 13699-5722
 * USA
 * http://critical.sf.net
 */
 
package edu.clarkson.serl.critic.interpreter.model;

import edu.clarkson.serl.critic.interpreter.ISymbol;
import edu.clarkson.serl.critic.interpreter.Interpreter;
import soot.Value;
import soot.jimple.EqExpr;

/**
 * 
 * @author <a href="http://clarkson.edu/~rupakhcr">Chandan R. Rupakheti</a> (rupakhcr@clarkson.edu)
 */
public class ExprEq extends ExprCondition<EqExpr> {

	/**
	 * @param sootValue
	 */
	public ExprEq(EqExpr sootValue, ISymbol<? extends Value> left, ISymbol<? extends Value> right) {
		super(sootValue, left, right);
	}

	@Override
	public ExprAbstract<? extends Value> execute(Object lValue, Object rValue) {

		// For all types
		if(lValue == rValue)
			return Interpreter.TRUE;
		
		// If both values are not equal and one of them is null
		if(lValue == null || rValue == null) 
			return Interpreter.FALSE;
		
		// For primitive types we will operate in double precision
		try {
			double l = Double.parseDouble(lValue.toString());
			double r = Double.parseDouble(rValue.toString());
			if(l == r) 
				return Interpreter.TRUE;
		}
		catch(NumberFormatException e){}
		
		return Interpreter.FALSE;
	}
}
