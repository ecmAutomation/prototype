/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.getstarted.loanapproval;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CalculateInterestService implements JavaDelegate {

  public void execute(DelegateExecution execution) throws Exception {

	String jobID = (String) execution.getVariable("jobID");
    System.out.println("Spring Bean invoked");
     Random r = new Random();
    int Low = 10;
    int High = 100;
    int result = r.nextInt(High-Low) + Low;
    execution.setVariable("jobID", "JOB"+result);
    System.out.println("jobID is " + jobID);

  }

}
