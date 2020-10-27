package com.mining.platform.security.communication

import com.mining.platform.core.Application
import com.mining.platform.core.communication.CommunicationService
import com.mining.platform.core.communication.protocol.Protocol
import com.mining.platform.core.communication.topic.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import javax.annotation.PostConstruct

/**
 *
 * @author luiz.bonfioli
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class CommunicationManager {

    private val logger = Logger.getLogger(CommunicationManager::class.qualifiedName)

    @Autowired
    private lateinit var application: Application

    // @Autowired
    // private val deviceService: DeviceService? = null

    @Autowired
    private lateinit var topicService: TopicService

    @Autowired
    private lateinit var communicationService: CommunicationService

    /**
     * Build the application topics
     */
    @PostConstruct
    private fun initialize() {
        try {
            buildServiceTopics()
            buildDeviceTopics()
            initializeCommunication()
        } catch (ex: Exception) {
            logger.log(Level.SEVERE, "Cannot build topics on starting server.", ex)
        }
    }

    /**
     * Build the service topics
     */
    private fun buildServiceTopics() {
        buildServiceInboundTopics()
        buildServiceOutboundTopics()
    }

    /**
     *
     */
    private fun buildServiceInboundTopics() {
        val companyTopic = TopicUtils.formatTopicByApplication(Protocol.Topic.COMPANY, application.name)
        val companyExchange = Protocol.Fanout.COMPANY_EVENT;
        topicService.create(companyTopic, companyExchange, TopicType.SERVICE_INBOUND,
                ExchangeType.SERVICE_FANOUT_EXCHANGE)
    }

    /**
     *
     */
    private fun buildServiceOutboundTopics() {
        val companyTopic = TopicUtils.formatTopicByApplication(Protocol.Topic.COMPANY, application.name)
        val companyExchange = Protocol.Fanout.COMPANY_EVENT;
        topicService.create(companyTopic, companyExchange, TopicType.SERVICE_OUTBOUND,
                ExchangeType.SERVICE_FANOUT_EXCHANGE)
    }

    /**
     *
     * @param companyToken
     * @return
     */
    fun buildCompanyInboundTopics(companyToken: UUID): Collection<TopicEntity> {
        val topics: MutableList<TopicEntity> = ArrayList()

        return topics
    }

    /**
     *
     * @param entity
     */
    fun buildCompanyOutboundTopics(companyToken: UUID): Collection<TopicEntity> {
        val topics: MutableList<TopicEntity> = ArrayList()

        return topics
    }

    /**
     *
     */
    private fun buildDeviceTopics() {
//        for (device in deviceService.findAll()) {
//            buildDeviceInboundTopics(device)
//            buildDeviceOutboundTopics(device)
//        }
    }

    /**
     *
     * @param deviceEntity
     * @return
     */
//    fun buildDeviceInboundTopics(deviceEntity: DeviceEntity): List<TopicEntity> {
//        val topics: MutableList<TopicEntity> = ArrayList<TopicEntity>()
//        val companyToken: String = deviceEntity.getCompanyToken().toString()
//        val deviceToken: String = deviceEntity.getId().toString()
//        val authenticationRequestTopic: String = TopicUtils
//                .formatTopic(Topic.SIGGA_AUTHENTICATION_REQUEST, companyToken, deviceToken)
//        topics.add(topicService.create(authenticationRequestTopic, Topic.MQTT_DEFAULT,
//                TopicType.MQTT_INBOUND, ExchangeType.TOPIC_EXCHANGE))
//        return topics
//    }

    /**
     *
     * @param deviceEntity
     * @return
     */
//    fun buildDeviceOutboundTopics(deviceEntity: DeviceEntity): List<TopicEntity> {
//        val topics: MutableList<TopicEntity> = ArrayList<TopicEntity>()
//        val companyToken: String = deviceEntity.getCompanyToken().toString()
//        val deviceToken: String = deviceEntity.getId().toString()
//        val authenticationResponseTopic: String = TopicUtils
//                .formatTopic(Topic.SIGGA_AUTHENTICATION_RESPONSE, companyToken, deviceToken)
//        topics.add(topicService.create(authenticationResponseTopic, Topic.MQTT_DEFAULT,
//                TopicType.MQTT_OUTBOUND, ExchangeType.TOPIC_EXCHANGE))
//        return topics
//    }

    /**
     *
     */
    private fun initializeCommunication() {
        communicationService.initialize()
    }
}