<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${mapperPackage}.${table.javaName}Mapper">
	<resultMap id="${table.javaName}_ResultMap" type="${modelPackage}.${table.javaName}">
	[#list table.cloumnList as cloumn ]
	[#if cloumn.name=="id"]
		<id column="${cloumn.jdbcName}" property="${cloumn.name}" />
		[#else]
		<result column="${cloumn.jdbcName}" property="${cloumn.name}" />
	[/#if]
	[/#list]
	</resultMap>

	<sql id="${table.javaName}_Column_List">
	[#list table.cloumnList as cloumn ]
		${cloumn.jdbcName}[#if cloumn_has_next],[/#if]
	[/#list]
	</sql>
	
	<insert id="insert" parameterType="${modelPackage}.${table.javaName}" useGeneratedKeys="true" keyProperty="id">
		insert into ${table.jdbcName}
		<trim prefix="(" suffix=")" suffixOverrides=",">
		[#list table.cloumnList as cloumn ]
			<if test="${cloumn.name} != null">
					${cloumn.jdbcName}[#if cloumn_has_next],[/#if]
			</if>
		[/#list]
		</trim>
		values <trim prefix="(" suffix=")" suffixOverrides=",">
		[#list table.cloumnList as cloumn ]
			<if test="${cloumn.name} != null">
					${r"#{"}${cloumn.name}}[#if cloumn_has_next],[/#if]
			</if>
		[/#list]
		</trim>
	</insert>

	<delete id="deleteById" parameterType="java.lang.Long">
		delete from ${table.jdbcName} where id = ${r"#{"}id}
	</delete>
	
	<delete id="deleteByProperty"  >
		delete from ${table.jdbcName} where 
			<choose>
				[#list table.cloumnList as cloumn ]
				[#if cloumn.name!="id"]
					<when test="property=='${cloumn.name}'">
						${cloumn.jdbcName} = ${r"#{"}value}
					</when>
				[/#if]
				[/#list]
			 </choose>
	</delete>
	
	<delete id="delete" >
		delete from ${table.jdbcName} where id in
		<foreach collection="ids" index="index" item="id" open="(" separator="," close=")">
            ${r"#{"}id}
         </foreach>
	</delete>

	<update id="update" parameterType="${modelPackage}.${table.javaName}">
		update ${table.jdbcName}
			<set>
				[#list table.cloumnList as cloumn ]
				[#if cloumn.name!="id"]
				<if test="${cloumn.name} != null">
					${cloumn.jdbcName} = ${r"#{"}${cloumn.name}}[#if cloumn_has_next],[/#if]
				</if>
				[/#if]
				[/#list]
			</set>
		where id = ${r"#{"}id}
	</update>
	
	<update id="updateByProperty" >
		update ${table.jdbcName}
			set 
		<choose>
		[#list table.cloumnList as cloumn ]
		[#if cloumn.name!="id"]
			<when test="property=='${cloumn.name}'">
				${cloumn.jdbcName} = ${r"#{"}value}
			</when>
		[/#if]
		[/#list]
		 </choose>
		where id = ${r"#{"}id}
	</update>
	
	<select id="getById"  parameterType="java.lang.Long" resultMap="${table.javaName}_ResultMap">
		select
			<include refid="${table.javaName}_Column_List" />
			from ${table.jdbcName}
		where id = ${r"#{"}id}
	</select>
	
	<select id="getByProperty" resultMap="${table.javaName}_ResultMap" >
		select
			<include refid="${table.javaName}_Column_List" />
			from ${table.jdbcName}
		where
		<choose>
		[#list table.cloumnList as cloumn ]
		[#if cloumn.name!="id"]
			<when test="property=='${cloumn.name}'">
				${cloumn.jdbcName} = ${r"#{"}value}
			</when>
		[/#if]
		[/#list]
		</choose>
	</select>

	<select id="getByExample" parameterType="${modelPackage}.${table.javaName}" resultMap="${table.javaName}_ResultMap" >
		select
			<include refid="${table.javaName}_Column_List" />
			from ${table.jdbcName}
		  <where>
			[#list table.cloumnList as cloumn ]
			[#if cloumn.name!="id" ]
			<if test="${cloumn.name} != null">
				and ${cloumn.jdbcName} = ${r"#{"}${cloumn.name}}
			</if>
			[/#if]
			[/#list]
		 </where>
			 
	</select>

	<select id="findAllByPage" resultMap="${table.javaName}_ResultMap" >
		select
			<include refid="${table.javaName}_Column_List" />
		from ${table.jdbcName}
	</select>
	
	<select id="findAll" resultMap="${table.javaName}_ResultMap" >
		select
			<include refid="${table.javaName}_Column_List" />
		from ${table.jdbcName}
	</select>
	
	<select id="findAllCount" resultMap="${table.javaName}_ResultMap" >
		select
			count(id)
		from ${table.jdbcName}
	</select>

	<select id="find${table.javaName}"  resultMap="${table.javaName}_ResultMap" >
		select * from (
			select
			<if test="dataType==0">
				<include refid="${table.javaName}_Column_List" />
			</if>
			<if test="dataType==1">
					id 
			</if>
				from ${table.jdbcName}
			  <where>
				<if test="min>0">
				<![CDATA[  
					and id < ${r"#{"}min}
				]]>
				</if>
				<if test="max>0">
				<![CDATA[ 
					and id > ${r"#{"}max}
					]]>
				</if>
				 
			 </where>
				 <if test="max lte 0">
				<![CDATA[  
					order by id desc
				]]>
				</if>
				<if test="max>0">
				<![CDATA[ 
					order by id asc
					]]>
				</if>
				<if test="pageSize>0">
				<![CDATA[ 
					limit 0 , ${r"#{"}pageSize}
					]]>
				</if>
				) t order by id desc
	</select>
	
	<select id="get${table.javaName}ByPage"  resultMap="${table.javaName}_ResultMap" >
			select
				<include refid="${table.javaName}_Column_List" />
				from ${table.jdbcName}
		 	order by id desc
	</select>
	
	<select id="get${table.javaName}Count"  resultType="int" >
			select
			 count(id)
				from ${table.jdbcName}
	</select>
	
	
</mapper>