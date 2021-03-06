/*
 * IFactory.java
 * Jul 13, 2011
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
 
package edu.clarkson.serl.critic.factory;

import java.util.List;
import java.util.Set;

import edu.clarkson.serl.critic.extension.ICheckPoint;
import edu.clarkson.serl.critic.interpreter.ISymbol;

import soot.SootMethod;
import soot.Value;
import soot.jimple.Stmt;

/**
 * 
 * @author <a href="http://clarkson.edu/~rupakhcr">Chandan R. Rupakheti</a> (rupakhcr@clarkson.edu)
 */
public interface IFactory {
	Set<String> getSupportedTypes();
	ISymbol<? extends Value> newSymbol(String type, Value value, boolean open, boolean mutable);
	Class<?> getClassFor(String type);
	Set<ICheckPoint> getCheckPoints();
	Set<SootMethod> getEntryMethods();
	public void checkEntry(SootMethod method);
	public boolean shouldInline(SootMethod method, ISymbol<? extends Value> receiver, List<ISymbol<? extends Value>> arguments, Stmt callSite);
}
