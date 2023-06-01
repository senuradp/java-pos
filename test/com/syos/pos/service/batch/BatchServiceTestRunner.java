/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.batch;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class BatchServiceTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BatchServiceTest.class);

        // Print test results
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Tests successful: " + result.wasSuccessful());
    }
}
