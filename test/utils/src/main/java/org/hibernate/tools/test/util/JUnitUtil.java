/*
 * Hibernate Tools, Tooling for your Hibernate Projects
 * 
 * Copyright 2017-2020 Red Hat, Inc.
 *
 * Licensed under the GNU Lesser General Public License (LGPL), 
 * version 2.1 or later (the "License").
 * You may not use this file except in compliance with the License.
 * You may read the licence in the 'lgpl.txt' file in the root folder of 
 * project or obtain a copy at
 *
 *     http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hibernate.tools.test.util;

import java.io.File;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.ComparisonFailure;

public class JUnitUtil {
	
	public static void assertIteratorContainsExactly(
			String reason, 
			Iterator<?> iterator, 
			int expectedAmountOfElements) {
		int actualAmountOfElements = 0;
		while (iterator.hasNext() && 
				actualAmountOfElements <= expectedAmountOfElements) {
			actualAmountOfElements++;
			iterator.next();
		}
		if (actualAmountOfElements != expectedAmountOfElements) {
			throw new ComparisonFailure(
					reason, 
					Integer.toString(expectedAmountOfElements),
					Integer.toString(actualAmountOfElements));
		}
	}
	
	public static void assertIsNonEmptyFile(File file) {
		Assert.assertTrue(file + " does not exist", file.exists() );
		Assert.assertTrue(file + " not a file", file.isFile() );		
		Assert.assertTrue(file + " does not have any contents", file.length()>0);
	}

}
