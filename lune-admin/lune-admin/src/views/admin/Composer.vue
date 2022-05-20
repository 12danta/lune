<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="composerName" label="Name" width="180"> </el-table-column>
    <el-table-column label="Pic" width="180">
        <template slot-scope="scope">
          <div class="demo-image__preview">
          <el-image
          style="width: 100px; height: 100px"
          :src="url"
          :preview-src-list="srcList">
        </el-image>
      </div>
          <el-button
              size="mini"
              type="warning"
              plain
              @click="handleUpdatePic(scope.$index, scope.row)">update</el-button>
        </template>
    </el-table-column>
    <el-table-column prop="composerIntroduction" label="Introduction" width="300" ></el-table-column>
    <el-table-column prop="composerLifeAndDeath" label="life and death" width="150" ></el-table-column>
    <el-table-column
      prop="composerPeriod"
      label="Period"
      :filters="[{ text: 'violinist', value: 'violinsit' }, { text: 'pianist', value: 'pianist' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          disable-transitions>{{scope.row.composerPeriod}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column   align="right">
        <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Del</el-button>
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>
<script>
export default {
  data () {
    return {
      tableData: [
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        }
      ],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      srcList: [
        'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
        'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],
      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.user_status === value
    },
    handleUpdatePic (index, row) {
      console.log(index, row)
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    }
  }
}
</script>
<style scope>

</style>
