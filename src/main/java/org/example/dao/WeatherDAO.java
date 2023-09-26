package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.model.WeatherEntity;
import org.example.model.WeatherTodayEntity;

import java.util.List;

public class WeatherDAO {

    private static EntityManagerFactory emf;
    private static WeatherDAO instance;

    public static WeatherDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new WeatherDAO();
        }
        return instance;
    }

    public WeatherEntity getWeather(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(WeatherEntity.class, id);
        }
    }

    public List<WeatherEntity> getAllWeather() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<WeatherEntity> query = em.createQuery("SELECT w FROM WeatherEntity w", WeatherEntity.class);
            List<WeatherEntity> weather = query.getResultList();
            return weather;
        }
    }

        public void updateWeather(WeatherEntity weather) {
            try (EntityManager em = emf.createEntityManager()) {
                em.getTransaction().begin();
                em.merge(weather);
                em.getTransaction().commit();
            }
        }

        public void deleteWeather(int id) {
            try (EntityManager em = emf.createEntityManager()) {
                em.getTransaction().begin();
                WeatherEntity weather = getWeather(id);
                if (weather != null) {
                    em.remove(weather);
                }
                em.getTransaction().commit();
            }
        }

        public void createWeather(WeatherEntity weather) {
            try (EntityManager em = emf.createEntityManager()) {
                em.getTransaction().begin();
                em.persist(weather);
                em.getTransaction().commit();
            }
        }

        // WeatherTodayEntity
        public void createWeatherToday(WeatherTodayEntity weatherToday) {
            try (EntityManager em = emf.createEntityManager()) {
                em.getTransaction().begin();
                em.persist(weatherToday);
                em.getTransaction().commit();
            }
        }

        public void updateWeatherToday(WeatherTodayEntity weatherToday) {
            try (EntityManager em = emf.createEntityManager()) {
                em.getTransaction().begin();
                em.merge(weatherToday);
                em.getTransaction().commit();
            }
        }

        public void deleteWeatherToday(int id) {
            try (EntityManager em = emf.createEntityManager()) {
                em.getTransaction().begin();
                WeatherTodayEntity weatherToday = getWeatherToday(id);
                if (weatherToday != null) {
                    em.remove(weatherToday);
                }
                em.getTransaction().commit();
            }
        }

        public WeatherTodayEntity getWeatherToday(int id) {
            try (EntityManager em = emf.createEntityManager()) {
                return em.find(WeatherTodayEntity.class, id);
            }
        }

    }
