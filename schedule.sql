-- SCHEDULE 테이블 생성
CREATE TABLE `SCHEDULE` (
                            `id`	bigint	NOT NULL,
                            `user_id`	bigint	NOT NULL,
                            `title`	varchar(50)	NOT NULL,
                            `contents`	varchar(200)	NOT NULL,
                            `created_at`	datetime	NOT NULL	DEFAULT current_timestamp,
                            `updated_at`	datetime	NOT NULL	DEFAULT current_timestamp
};

-- 일정 생성 쿼리
INSERT INTO SCHEDULE(id,
                     title,
                     contents,
                     created_at,
                     updated_at)
VALUES (1,
        "일정 제목",
        "일정 내용",
         current_timestamp,
         current_timestamp
       );



-- 일정 삭제 쿼리
DELETE
FROM SCHEDULE
WHERE id = 1;

-- 일정 목록 조회 쿼리
SELECT *
FROM SCHEDULE
ORDER BY updated_at DESC; --수정일 기준 내림차순 정렬
