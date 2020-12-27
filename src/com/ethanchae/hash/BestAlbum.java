package com.ethanchae.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * <p>
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 * <p>
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 * <p>
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 *
 * 31:53
 *
 */
public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> bestAlbumList = new ArrayList<>();
        HashMap<String, PriorityQueue<Track>> trackList = parsingAlbumList(genres, plays);
        PriorityQueue<Album> albumList = parsingAlbum(trackList);

        while(!albumList.isEmpty()){
            Album album = albumList.poll();
            PriorityQueue<Track> tracks = album.tracks;
            bestAlbumList.add(tracks.poll().idx);
            if (!tracks.isEmpty()) bestAlbumList.add(tracks.poll().idx);
        }

        return getBestTrackList(bestAlbumList);
    }

    private int[] getBestTrackList(List<Integer> bestAlbumList) {
        int[] indexes = new int[bestAlbumList.size()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = bestAlbumList.get(i);
        }
        return indexes;
    }

    private PriorityQueue<Album> parsingAlbum(HashMap<String, PriorityQueue<Track>> trackList){
        PriorityQueue<Album> albumList = new PriorityQueue<>();
        for(String genre : trackList.keySet()){
            Album album = new Album(trackList.get(genre));
            albumList.add(album);
        }
        return albumList;
    }

    private HashMap<String, PriorityQueue<Track>> parsingAlbumList(String[] genres, int[] plays) {
        HashMap<String, PriorityQueue<Track>> albumList = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Track track = new Track(genre, plays[i], i);
            PriorityQueue<Track> tracks = albumList.getOrDefault(genre, new PriorityQueue<>());
            tracks.add(track);
            albumList.put(genre, tracks);
        }
        return albumList;
    }


    public class Album implements Comparable<Album> {
        private final PriorityQueue<Track> tracks;
        private final int playCount;

        public Album(PriorityQueue<Track> tracks) {
            this.tracks = tracks;
            int count = 0;
            for (Track track : tracks) {
                count += track.playCount;
            }
            this.playCount = count;
        }

        @Override
        public int compareTo(Album o) {
            if (o.playCount > this.playCount) return 1;
            else if (o.playCount < this.playCount) return -1;
            return 0;
        }
    }

    public class Track implements Comparable<Track> {
        private final String genre;
        private final int playCount;
        private final int idx;

        public Track(String genre, int playCount, int idx) {
            this.genre = genre;
            this.playCount = playCount;
            this.idx = idx;
        }

        @Override
        public int compareTo(Track o) {
            if (o.playCount > this.playCount) return 1;
            else if (o.playCount < this.playCount) return -1;
            if (o.idx < this.idx) return 1;
            else return -1;
        }
    }
}
