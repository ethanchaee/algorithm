package com.ethanchae.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class DiscController {

    @Test
    public void test() {
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        int result = solution(jobs);

        assertEquals(9, result);

    }


    public int solution(int[][] jobs) {
        int time = 0;
        PriorityQueue<Job> jobList = new PriorityQueue<>();
        PriorityQueue<Job> peekList = new PriorityQueue<>();

        List<Job> resultJobList = new ArrayList<>();

        for (int[] job : jobs) {
            jobList.offer(new Job(job[0], job[1]));
        }

        while (!jobList.isEmpty()) {
            peekList.clear();
            peekList.addAll(jobList);
            Job job = peekJob(time, peekList);
            //해당 시간이 요청한 일이 없을 수 있으므로 다음 시간으로 넘김
            if(job == null) {
                time++;
                continue;
            }
            jobList.remove(job);
            time += job.duration;
            job.setEndTime((time - job.requestTime));
            resultJobList.add(job);
        }

        return getAverageTimeToWork(resultJobList);
    }

    private Job peekJob(int currentTime, PriorityQueue<Job> jobList) {
        if (jobList.isEmpty()) return null;
        Job job = jobList.poll();
        if (currentTime < job.requestTime) {
            return peekJob(currentTime, jobList);
        }
        return job;
    }

    private int getAverageTimeToWork(List<Job> resultJobList) {
        int sum = 0;
        for (Job job : resultJobList) {
            sum += job.endTime;
        }
        return (sum / resultJobList.size());
    }

    class Job implements Comparable<Job> {
        private final int requestTime;
        private final int duration;

        private int endTime;

        Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Job job) {
            if (this.duration > job.duration) {
                return 1;
            } else if (this.duration < job.duration) {
                return -1;
            }
            return 0;
        }
    }
}
