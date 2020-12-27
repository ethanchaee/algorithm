package com.ethanchae.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 * 문제 설명
 * 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
 * <p>
 * 예를들어
 * <p>
 * - 0ms 시점에 3ms가 소요되는 A작업 요청
 * - 1ms 시점에 9ms가 소요되는 B작업 요청
 * - 2ms 시점에 6ms가 소요되는 C작업 요청
 * 와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.
 *
 * 1. 짧은 걸 먼저하는게 좋음
 * 2. 단 해당 요청이 들어와있는 상태여야 함
 */
public class DiscController {
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

    class Job implements Comparable<Job>{
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
