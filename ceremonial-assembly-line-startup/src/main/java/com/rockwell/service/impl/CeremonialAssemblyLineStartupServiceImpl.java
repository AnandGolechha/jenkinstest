/**
 * 
 */
package com.rockwell.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rockwell.model.Mode;
import com.rockwell.model.PLC;
import com.rockwell.model.Result;
import com.rockwell.service.CeremonialAssemblyLineStartupService;

/**
 * @author anand.golechha
 *
 */
@Service
public class CeremonialAssemblyLineStartupServiceImpl implements CeremonialAssemblyLineStartupService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CeremonialAssemblyLineStartupServiceImpl.class);

	public Result getInogurationProcessResult(int employeeCount) {

		List<PLC> plcs = new ArrayList<>(employeeCount);

		// This will be executed by first employee
		for (int i = 0; i < employeeCount; i++) {
			plcs.add(new PLC(Mode.RUNNING));
		}

		// Executed by second employee
		for (int i = 1; i < employeeCount; i += 2) {
			plcs.get(i).setMode(Mode.PROGRAM);
		}

		// Remaining employee's will be doing
		for (int i = 2; i < employeeCount; i++) {
			// i'th employee's task
			for (int j = i; j < employeeCount; j += (i+1)) {
				plcs.get(j).flipMode();
			}
		}

		String message = String.format("After %s emplyee %s PLC will be in RUN mode", employeeCount,
				plcs.parallelStream().filter(plc -> Mode.RUNNING.equals(plc.getMode())).count());

		LOGGER.info(message);

		return new Result(message);
	}
}
