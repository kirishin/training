package jp.or.yanbarukuina.aopSampleProject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Class2 {
	public Class2() {
		log.info("{}がインスタンス化されました。", this);
	}
	@Override
	public String toString() {
		return "Class2";
	}
}
