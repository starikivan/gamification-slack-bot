package juja.microservices.gamification.slackbot.service;

import juja.microservices.gamification.slackbot.dao.GamificationRepository;
import juja.microservices.gamification.slackbot.model.*;

import javax.inject.Inject;

/**
 * @author Danil Kuznetsov
 */
public class DefaultGamificationService implements GamificationService {

    private final GamificationRepository gamificationRepository;

    @Inject
    public DefaultGamificationService(GamificationRepository gamificationRepository) {
        this.gamificationRepository = gamificationRepository;
    }

    @Override
    public String sendDailyAchievement(DailyAchievement daily) {
        return gamificationRepository.saveDailyAchievement(daily);
    }

    @Override
    public String sendCodenjoyAchievement(CodenjoyAchievement codenjoy) {
        return gamificationRepository.saveCodenjoyAchievement(codenjoy);
    }

    @Override
    public String sendThanksAchievement(ThanksAchievement thanks) {
        return gamificationRepository.saveThanksAchievement(thanks);
    }

    @Override
    public String saveInterviewAchievement(InterviewAchievement interview) {
        return gamificationRepository.saveInterviewAchievement(interview);
    }
}
